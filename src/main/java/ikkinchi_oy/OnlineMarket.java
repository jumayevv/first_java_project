package ikkinchi_oy;

import java.util.concurrent.CountDownLatch;

public class OnlineMarket {
    private CountDownLatch countDownLatch;
    public OnlineMarket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    public void qoshilish(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("mahsulot sotib olindi");
        countDownLatch.countDown();
    }
    public void topga_chiqar(){
        System.out.println("Mahsulot topga chiqdi");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(20);
        OnlineMarket obj = new OnlineMarket(latch);
        for (int i = 0; i < 50; i++) {
            new Thread(obj::qoshilish).start();
        }
        latch.await();
        obj.topga_chiqar();
    }
}
