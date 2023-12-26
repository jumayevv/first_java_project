package Dars.ikkinchi_oy;

import java.util.concurrent.CountDownLatch;

public class VideoKonfirensiya {
    private CountDownLatch countDownLatch;
    public VideoKonfirensiya(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    public void qoshilish(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("odam qo'shildi");
        countDownLatch.countDown();
    }
    public void konferensiya_boshlash(){
        System.out.println("konferensiya bohslandi");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        VideoKonfirensiya obj = new VideoKonfirensiya(latch);
        for (int i = 0; i < 50; i++) {
            new Thread(obj::qoshilish).start();
        }
        latch.await();
        obj.konferensiya_boshlash();
    }
}
