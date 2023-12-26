package Dars.ikkinchi_oy;

import java.util.concurrent.Semaphore;

public class AvtoService {
    private Semaphore semaphore;
    public AvtoService(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    public void xizmatKorsatish () {
        try {
            System. out.println(Thread. currentThread().getName() + " xizmat uchun navbatga keldi" );
            semaphore.acquire();
            System.out.println(Thread. currentThread().getName() + " uchun xizmat ko'rsatilmoqda..." );
            Thread. sleep(200);
            System. out.println(Thread. currentThread().getName() + " uchun xizmat ko'rsatib bo'lindi navbat bo'shadi!" );
            semaphore.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Semaphore s = new Semaphore(2);
        AvtoService avtoService = new AvtoService(s);
        for (int i=0; i<20; i++){
            new Thread(avtoService::xizmatKorsatish).start();
        }
    }
}
