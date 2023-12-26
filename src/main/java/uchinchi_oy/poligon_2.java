package uchinchi_oy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class poligon_2 {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> numbers = Arrays.asList(1, 3, 6, 8, 10, 18, 36);

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);

        System.out.println("-> " + average);
        System.out.println("The average of the list is " + average);

//---------------------------------------------------------------------------

        AtomicInteger counter =new AtomicInteger();

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.incrementAndGet();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.incrementAndGet();
            }});

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        System.out.println("Counter value: " + counter);

    }
}
