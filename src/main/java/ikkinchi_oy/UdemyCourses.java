package Dars.ikkinchi_oy;

import java.util.concurrent.CountDownLatch;

public class UdemyCourses {
    private CountDownLatch countDownLatch;
    public UdemyCourses(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    public void kursga_qatnashish(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("accepted " );
        countDownLatch.countDown();
    }
    public void rek(){
        System.out.println("kurs rekomendatsiyada");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(100);
        UdemyCourses obj = new UdemyCourses(latch);
        for (int i = 0; i < 200; i++) {
            new Thread(obj::kursga_qatnashish).start();
        }
        latch.await();
        obj.rek();

    }
}
