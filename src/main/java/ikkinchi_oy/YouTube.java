package Dars.ikkinchi_oy;

import java.util.concurrent.CountDownLatch;

public class YouTube {
    private CountDownLatch countDownLatch;
    public YouTube(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void view(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("viewed");
        countDownLatch.countDown();

    }
    public void rek(){
        System.out.println("Video rekomendatsiyada");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch =new CountDownLatch(4);
        YouTube obj = new YouTube(latch);
        for (int i = 0; i < 50; i++) {
            new Thread(obj::view).start();
        }
        latch.await();
        obj.rek();

    }
}
