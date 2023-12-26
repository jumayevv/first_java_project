package Dars.ikkinchi_oy;

import java.util.concurrent.CountDownLatch;

public class ruchka {
    enum ruchkaStatus {
        THREAD_BIR,
        THREAD_IKKI,
        THREAD_UCH
    }
    int siyoh = 100;
    static ruchkaStatus ruchkaStatus = ruchka.ruchkaStatus.THREAD_BIR;
    public synchronized void forThread1() {
        while (siyoh > 0) {
            while (ruchkaStatus != ruchkaStatus.THREAD_BIR) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            siyoh -= 10;
            System.out.println(Thread.currentThread().getName() + " ruchkadan foydalandi");
            ruchkaStatus = ruchkaStatus.THREAD_IKKI;
            notifyAll();
        }
    }

    public synchronized void forThread2() {
        while (siyoh > 0) {
            while (ruchkaStatus!= ruchka.ruchkaStatus.THREAD_IKKI) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            siyoh -= 10;
            System.out.println(Thread.currentThread().getName() + " ruchkadan foydalandi");
            ruchkaStatus = ruchka.ruchkaStatus.THREAD_BIR;
            notifyAll();
        }
    }


    public static void main(String[] args) {
        ruchka obj = new ruchka();
        Thread t1 = new Thread(() -> {
            obj.forThread1();
        },"Thread 1");
        Thread t2 = new Thread(() -> {
            obj.forThread2();
        },"Thread 2");

        t1.start();
        t2.start();

    }
}
