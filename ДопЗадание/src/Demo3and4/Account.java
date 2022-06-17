package Demo3and4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//VK Stat и Хакеры
public class Account {

    private final Lock lock = new ReentrantLock();
    private final Condition fansAdded = lock.newCondition();
    private long popularity;

    public Account() {
        this.popularity = 0L;
    }

    public Account(long popularity) {
        this.popularity = popularity;
    }

    public long getStats() {
        lock.lock();
        try {
            return popularity;
        } finally {
            lock.unlock();
        }
    }

    public void cheatViews(long amount) {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            popularity += amount;
            fansAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void hackerAttack(long amount) {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            if (popularity < amount) {
                throw new IllegalArgumentException("Недостаточно фанатов");
            }
            popularity -= amount;
        } finally {
            lock.unlock();
        }
    }

    public void waitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            while (popularity < amount) {
                fansAdded.await();
            }
            this.hackerAttack(amount);
        } finally {
            lock.unlock();
        }
    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
