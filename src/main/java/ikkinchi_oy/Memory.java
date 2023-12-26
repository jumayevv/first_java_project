package Dars.ikkinchi_oy;

public class Memory {
    enum memoryStatus{
        THREAD_BIR,
        THREAD_IKKI,
        THREAD_UCH
    }
    int memory = 1000;
    static memoryStatus memoryStatus = Memory.memoryStatus.THREAD_BIR;
    public synchronized void forThread1() {
        while (memory > 20) {
            while(memoryStatus != memoryStatus.THREAD_BIR) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            memory -= 10;
            System.out.println(Thread.currentThread().getName() + " joy egalladi\n qolgan joy: " + this.memory);
            memoryStatus = memoryStatus.THREAD_IKKI;
            notifyAll();
        }
    }

    public synchronized void forThread2() {
        while (memory > 20) {
            while(memoryStatus != memoryStatus.THREAD_IKKI) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            memory -= 10;
            System.out.println(Thread.currentThread().getName() + " joy egalladi\n qolgan joy: " + this.memory);
            memoryStatus = memoryStatus.THREAD_UCH;
            notifyAll();
        }
    }

    public synchronized void forThread3() {
        while (memory > 20) {
            while (memoryStatus != Memory.memoryStatus.THREAD_UCH) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            memory -= 10;
            System.out.println(Thread.currentThread().getName() + " joy egalladi\n qolgan joy: " + this.memory);
            memoryStatus = Memory.memoryStatus.THREAD_BIR;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        Memory obj = new Memory();
        Thread t1 = new Thread(() -> {
            obj.forThread1();
        },"Thread 1");
        Thread t2 = new Thread(() -> {
            obj.forThread2();
        },"Thread 2");
        Thread t3 = new Thread(() -> {
            obj.forThread3();
        },"Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }
}
