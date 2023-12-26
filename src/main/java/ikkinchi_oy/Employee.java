package Dars.ikkinchi_oy;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    public String ismi;
    public AtomicInteger oylik;

    public Employee(String ismi, int oylik) {
        this.ismi = ismi;
        this.oylik = new AtomicInteger(oylik);
    }

    public  void oshir(){
        System.out.println(Thread.currentThread().getName() + " oshirdi " + oylik.incrementAndGet());
    }

    @Override
    public String toString() {
        return "Emplpyee{" +
                "ismi='" + ismi + '\'' +
                ", oylik=" + oylik +
                '}';
    }
}
