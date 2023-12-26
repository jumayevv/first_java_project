package Dars.ikkinchi_oy;

import java.util.concurrent.atomic.AtomicInteger;

public class Mahsulot {
    public AtomicInteger yaroqli_muddat;
    public String name;
    Mahsulot(String name,int n) {
        this.yaroqli_muddat = new AtomicInteger(n);
        this.name=name;
    }

    public void decrement(){
        System.out.println(Thread.currentThread().getName() +this.name+ " ni muddat kamaydi " + this.yaroqli_muddat.decrementAndGet());
    }
}
