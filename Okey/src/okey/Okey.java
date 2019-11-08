package okey;

import java.util.Arrays;
import java.util.Collections;



/**
 *
 * @author cemal
 */
public class Okey {

    public static void main(String[] args) {
        Tile x = new Tile();
        Player p=new Player();
        x.Bag();   //taşları torbaya doldurur
        x.mixBag();        //torbayı karıştır
        x.getOkey(x.arr);  //okeyi belirler
        p.setTile(x.arr);  // taşları oyunculara dağıtır.
        p.printBoards();   //oyuncuların ıstakalarını gösterir
        System.out.println();
        p.control();      //puanlama yapar
        System.out.println("Puanlar : " + Arrays.toString(p.puan.toArray()));
        System.out.println("Kazanan "+ (p.puan.indexOf(Collections.max(p.puan))+1) +". oyuncu");
        
        
    }
    
}
