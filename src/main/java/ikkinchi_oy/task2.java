package Dars.ikkinchi_oy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class task2 {
    enum videoStatus{
        STANDART,
        POPULAR,
        NEG_STANDART,
        NEG_POPULAR
    }

    private videoStatus v_status= videoStatus.STANDART;
    private videoStatus neg_status= videoStatus.NEG_STANDART;
    private AtomicInteger numberOfLikes;
    private AtomicInteger numberOfDislikes;

    private CountDownLatch countDownLatch;
    private CountDownLatch neg_countDownLatch;
    task2(CountDownLatch count,CountDownLatch count2) {

        this.numberOfLikes = new AtomicInteger(0);
        this.numberOfDislikes = new AtomicInteger(0);
        this.countDownLatch = count;
        this.neg_countDownLatch = count2;
    }
    public void like(){
        System.out.println(Thread.currentThread().getName() + " video liked, count:" + numberOfLikes.updateAndGet(v->v + 5));
        this.countDownLatch.countDown();
    }
    public void dislike(){
        System.out.println(Thread.currentThread().getName() + " video disliked, count:" + numberOfLikes.updateAndGet(v->v+1));
        this.neg_countDownLatch.countDown();
    }

    public void setV_status() {
        this.v_status = videoStatus.POPULAR;
    }

    public void setNeg_status() {
        this.neg_status = videoStatus.NEG_POPULAR;
    }

    public videoStatus getV_status() {
        return v_status;
    }

    public videoStatus getNeg_status() {
        return neg_status;
    }

    public AtomicInteger getNumberOfUsers() {
        return numberOfLikes;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(10);
        CountDownLatch count2 = new CountDownLatch(10);

        task2 obj = new task2(count,count2);
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            ex.submit(obj::like);
            ex.submit(obj::dislike);
        }
        count.await();
        count2.await();
        obj.setNeg_status();
        obj.setV_status();
        Thread.sleep(400);
        ex.shutdown();
        System.out.println(obj.getV_status() +"\n"+obj.getNeg_status());
    }
}
