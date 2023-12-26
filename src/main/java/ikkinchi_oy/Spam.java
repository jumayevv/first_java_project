package Dars.ikkinchi_oy;

import java.util.concurrent.CountDownLatch;

public class Spam {
    private CountDownLatch countDownLatch;
    public Spam(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    public void spam_berish(){
        try {
            Thread.sleep(90);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("spam bosildi " );
        countDownLatch.countDown();
    }
    public void cheklov(){
        System.out.println("spamlar soni 3 taga yetdi, cheklov qo'yildi !");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Spam obj = new Spam(latch);
        for (int i = 0; i < 100; i++) {
            new Thread(obj::spam_berish).start();
        }
        latch.await();
        obj.cheklov();

    }
}
