package Dars.ikkinchi_oy;

import java.util.concurrent.Semaphore;

public class Savdo {
        private Semaphore semaphore;
        public Savdo(Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        public void xizmatKorsatish () {
            System. out.println(Thread. currentThread().getName() + " mijoz keldi" );
            try {
                semaphore.acquire();
                System.out.println(Thread. currentThread().getName() + " mijoz kassadan foydalanyabdi..." );
                Thread. sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System. out.println(Thread. currentThread().getName() + " mijoz savdo qilib bo'ldi !" );
            semaphore.release();

        }
        public static void main(String[] args){
            Semaphore s = new Semaphore(3);
            Savdo bankXizmati = new Savdo(s);
            for (int i=0; i<5; i++){
                new Thread(bankXizmati::xizmatKorsatish).start();
            }
        }
}
