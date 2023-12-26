package Dars.ikkinchi_oy;

public class Uzcard {
    private double balance=0;

    public void increment(int s){
        this.balance+=s;
        System.out.println("balance oshdi");
    }

    public void decrement(int s){
        this.balance-=s;
        System.out.println("balance kamaydi");
    }
    public double getBalance() {
        return this.balance;
    }
}
