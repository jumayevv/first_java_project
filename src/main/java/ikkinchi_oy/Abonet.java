package Dars.ikkinchi_oy;

public class Abonet {
    private double balans=200;
    synchronized public void decrement(){
        for (int i = 0; i < 10; i++) {
            this.balans -= 10;
            System.out.println(Thread.currentThread().getName() + " | "+this.balans);
        }
    }
}
