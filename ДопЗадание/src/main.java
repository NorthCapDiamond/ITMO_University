import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class main {
    public static void main(String[] args) throws InterruptedException {

        //SHOW1
        Semaphore semaphore = new Semaphore(7);
        semaphore.acquire();
        try {
            // можно до 7 потоков
            // код может работать одновременно

        }finally {
            semaphore.release();
        }


        //SHOW2
        CountDownLatch countDownLatch = new CountDownLatch(7);
        // latch.countDown() 7 раз
        countDownLatch.await();


        //SHOW3

        Lock locker = new ReentrantLock();

        locker.lock();
        try {
            //что-то делаем
        }finally {
            locker.unlock();
        }

    }
}
