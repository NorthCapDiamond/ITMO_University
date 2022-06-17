package Demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreShow {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3); //если мы захотим честную очередь, то вторым параметром в semaphore нужно указать true
        //Semaphore semaphore = new Semaphore(3,true);

        List <Thread> threadList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            ShowThread showThread = new ShowThread(semaphore);
            threadList.add(showThread);
            showThread.start();

        }

        Thread.sleep(20000);
        for (Thread thread: threadList){
            thread.interrupt();
        }
    }

    private static class ShowThread extends Thread{
        private final Semaphore semaphore;

        private ShowThread(Semaphore semaphore){
            this.semaphore = semaphore;
        }

        @Override
        public void run(){
            try {
                tryToRun();
            }catch (InterruptedException e){
                System.out.println(getName()+" А вот тут мы бросили interrupt...");
            }
        }
        private void tryToRun() throws  InterruptedException{
            while (true){
                semaphore.acquire();
                try {
                    System.out.println(getName() + " Взял Semaphore");
                    System.out.println(" Я люблю многопоток!!! Вот так вот, вот так вот "+getName());
                    Thread.sleep(7000L);
                }
                finally {
                    System.out.println(getName() + " отпускает semaphore");
                    semaphore.release();
                }
            }
        }
    }
}
