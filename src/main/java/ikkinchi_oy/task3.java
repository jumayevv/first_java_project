package Dars.ikkinchi_oy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class task3 {
    private AtomicInteger amount;

    public void pay_terminal(int summa){
        System.out.println(Thread.currentThread().getName() + " terminal orqali to'landi, summa: " + amount.updateAndGet(v->v+summa));
    }
    public void pay_naqd(int summa){
        System.out.println(Thread.currentThread().getName() + " naqd to'landi, summa: " + amount.updateAndGet(v->v+summa));
    }

    public AtomicInteger getAmount() {
        return amount;
    }

    public task3(int summa) {
        this.amount = new AtomicInteger(summa);
    }

    public static void main(String[] args) throws InterruptedException {
        task3 obj = new task3(100000);
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            ex.submit(()->{
                obj.pay_naqd(15000);
            });
            ex.submit(()->{
                obj.pay_terminal(10000);
            });
        }
        Thread.sleep(400);
        ex.shutdown();
        System.out.println(obj.getAmount());
    }
}
