package Dars.ikkinchi_oy;

public class VirtualHamyon {
    private double amount;

    synchronized public void increment(){
        for (int i = 0; i < 10; i++) {

            this.amount += 100;
            System.out.println(Thread.currentThread().getName() + " | "+this.amount);
        }
    }
}
