package Dars.ikkinchi_oy;

import java.util.ArrayList;
import java.util.List;

public class NarxlarService {
    public ArrayList<Integer> narxlar = new ArrayList<>(List.of(100,200,300,400,500));

    public void NarxniOshir(){
        for (int i = 0; i < narxlar.size(); i++) {
            narxlar.set(i,narxlar.get(i)+10);
            System.out.println(narxlar.get(i) +" | "+ Thread.currentThread().getName());
        }
    }
}
