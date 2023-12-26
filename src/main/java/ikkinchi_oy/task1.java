package Dars.ikkinchi_oy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class task1 {

    private AtomicInteger numberOfLikes;

    task1() {
        this.numberOfLikes = new AtomicInteger(0);
    }
    public void like(){
        System.out.println(Thread.currentThread().getName() + " video liked, count:" + numberOfLikes.updateAndGet(v->v + 5));
    }
    public void dislike(){
        System.out.println(Thread.currentThread().getName() + " video disliked, count:" + numberOfLikes.updateAndGet(v->v-1));
    }

    public AtomicInteger getNumberOfUsers() {
        return numberOfLikes;
    }

    public static void main(String[] args) throws InterruptedException {
        task1 obj = new task1();
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            ex.submit(obj::like);
            ex.submit(obj::dislike);
        }
        Thread.sleep(400);
        ex.shutdown();
        System.out.println(obj.getNumberOfUsers());
    }
}
