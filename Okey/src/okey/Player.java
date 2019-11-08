/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import static org.apache.commons.lang.ArrayUtils.contains;

/**
 *
 * @author cemal
 */
public class Player {

    HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> puan = new ArrayList<>();
    ArrayList<Integer> tempo = new ArrayList<>();

    public void setTile(int arr[]) {

        // oyuncuların ıstakaları için oluşturulan arrayler.
        int[] p1 = Arrays.copyOfRange(arr, 0, 15);
        int[] p2 = Arrays.copyOfRange(arr, 15, 29);
        int[] p3 = Arrays.copyOfRange(arr, 29, 43);
        int[] p4 = Arrays.copyOfRange(arr, 43, 57);
        
        //hesaplama ve kontrol için arrayler hashmape atanır.
        map.put(0, p1);
        map.put(1, p2);
        map.put(2, p3);
        map.put(3, p4);

    }

    //puanlama sistemi
    public void control() {
        Tile z = new Tile();

        for (int i = 0; i < map.size(); ++i) {
            int arr[] = (int[]) map.get(i);

            for (int x = 0; x < arr.length - 1; x++) {
                if (arr[x] == z.OKEY) {  // eğer oyuncuda okey varsa puanlama sistemine otomatik eklenir.
                    list.add(z.OKEY);
                    if (arr[x] == arr[x + 1]) {
                        tempo.add(z.OKEY);
                    }
                }
                
                if(contains(arr,52) && (((arr[x]+1)==z.OKEY ) || ((arr[x]-1)==z.OKEY) || (arr[x]- z.OKEY ==13))){ // eğer oyuncu sahte okeyi kullanabiliyorsa puanlamaya eklenir.
                    list.add(arr[x]);
                    list.add(52);
                
                }
                if (arr[x] == (arr[x + 1])) {  // oyuncunun elindeki aynı taşları tekrar kontrol etmemesi sağlanır.
                    x++;
                } else {
                    if (arr[x] == (arr[x + 1] - 1) && arr[x + 1] != 52) { // oyuncunun elindeki sıralı taşları puanlamaya ekler örneğin : 1,2,3
                        list.add(arr[x]);
                        list.add(arr[x + 1]);

                        for (int j = x + 1; j < arr.length; j++) {  // oyuncunun elindeki seri taşları puanlmaya ekler örneğin sarı 1,kırmızı 1, siyah 1.
                            if ((arr[j] - arr[x]) % 13 == 0) {
                                list.add(arr[x]);
                                list.add(arr[j]);
                            }
                        }
                    }
                }
            }

            Set<Integer> listWithoutDuplicates = new LinkedHashSet<Integer>(list); // puanlama hesaplanırken çakışan aynı taşları kontrol ve düzenlemek için.
            list.clear();
            list.addAll(listWithoutDuplicates);
            list.addAll(tempo);
            int size = list.size();
            puan.add(size);         //oyuncuların puanlarını bir liste ekler.
            System.out.println((i+1)+".Oyuncunun puan eden taşları : " + list);
            list.clear();
            System.out.println();
        }
      

    }

    public void printBoards() {  //oyuncuların taşlarını ekrana bastırır.
        for (int i = 0; i < map.size(); ++i) {
            Arrays.sort(map.get(i));
            System.out.print((i+1)+".Oyuncunun Eli : " + (Arrays.toString(map.get(i))) + " ");
            System.out.println();

        }
    }
   }


