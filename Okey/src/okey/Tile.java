/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okey;

import java.util.Random;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author cemal
 */
public class Tile {

    int[] arr = new int[106];
    public static int OKEY;

    
    
    
    // taşları (1 den 52ye kadar) arraya iki defa dolduruyor    
    public void Bag() { 
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = counter;
            if (counter == 52) {
                counter = 0;
            } else {
                counter++;
            }
        }

    }

    // arraya doldurulan taşları karıştırır
    public void mixBag() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

    }

    
    //okey belirleme
    public void getOkey(int[] array) {
        int rnd = 0;
        do {
            rnd = new Random().nextInt(array.length);
        } while (array[rnd] == 52);                // okey belirlenirken sahte okey gelirse tekrar taş çekilir.

        System.out.println("Okey için açılan gösterge : "+array[rnd]);

        if ((array[rnd] == 12) || (array[rnd] == 25) || (array[rnd] == 38) || (array[rnd] == 51)) { //gösterge 13 geldiğinde okeyi 1 olarak belirle örneğin yere kırmızı 13 açıldığında okeyin kırmızı 1 olması.

            arr = ArrayUtils.remove(arr, array[rnd]);
            OKEY = array[rnd] - 12;

        } else {  // açılan göstergenin 1 fazlası okey olarak belirlenir
            arr = ArrayUtils.remove(arr, array[rnd]);
            OKEY = array[rnd] + 1;
        }
        System.out.println("Belirlenen Okey : "+OKEY);
    }

    
    // doldurulan arrayı kontrol amaçlı yazılmıştır.
    void printArray() {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
