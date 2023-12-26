package Dars.ikkinchi_oy;

import java.time.ZonedDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class task4 {
    public void login()
    {
        System.out.println(Thread.currentThread().getName()+
                " saytga kirdi, vaqti: " +
                ZonedDateTime.now());
    }

    public static void main(String[] args) throws InterruptedException
    {
        task4 obj = new task4();
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++)
        {
            ex.submit(obj::login);
        }
        Thread.sleep(400);
        ex.shutdown();
    }
}
