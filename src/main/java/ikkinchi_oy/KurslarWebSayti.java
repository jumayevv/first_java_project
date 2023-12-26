package Dars.ikkinchi_oy;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class KurslarWebSayti {
    private Semaphore semaphore;
    public KurslarWebSayti(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    public void reklama_qilish () {
        System. out.println(Thread. currentThread().getName() + " reklama keldi" );
        try {
            semaphore.acquire();
            System.out.println(Thread. currentThread().getName() + " reklama ko'rsatilyabdi..." );
            Thread. sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System. out.println(Thread. currentThread().getName() + " reklama qilib bo'lindi !" );
        semaphore.release();
    }
    public static void main(String[] args){
        Semaphore s = new Semaphore(2);
        KurslarWebSayti avtoService = new KurslarWebSayti(s);
        for (int i=0; i<20; i++){
            new Thread(avtoService::reklama_qilish).start();
        }
    }
}
