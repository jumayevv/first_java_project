package Dars.ikkinchi_oy;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class PlasticCard {
    public AtomicReference<Double> amount;
    PlasticCard() {
        this.amount = new AtomicReference<>(0.0);
    }

    public void pul_otkaz(){
        System.out.println(Thread.currentThread().getName() + " pul o'tkazdi " + amount.updateAndGet(v->v+10));
    }

    public void pul_yechihs(){
        System.out.println(Thread.currentThread().getName() + " pul yechildi " + amount.updateAndGet(v -> v - 5));
    }

    public AtomicReference<Double> getAmount() {
        return amount;
    }

    public static void main(String[] args) throws InterruptedException {
        PlasticCard card = new PlasticCard();
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            ex.submit(card::pul_otkaz);
            ex.submit(card::pul_yechihs);
        }
        Thread.sleep(500);
        ex.shutdown();
        System.out.println(card.getAmount().get());
    }
}
