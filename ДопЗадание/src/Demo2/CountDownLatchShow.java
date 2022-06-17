package Demo2;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchShow {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(15);

        for (int i = 0; i < 15; i++) {
            new ShowThread(countDownLatch).start();
        }

    }


    private static class ShowThread extends Thread{
        private final CountDownLatch countDownLatch;
        private  ShowThread(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run(){
            try {
                tryToRun();
            }catch (InterruptedException e){
                System.out.println(getName()+" А вот тут мы бросили interrupt...");
            }
        }
        private void tryToRun() throws InterruptedException{
            // Фаза инициализации потока
            Thread.sleep((long) (Math.random()*15000L));
            System.out.println(getName()+": Я родился!!!!");
            countDownLatch.countDown();
            countDownLatch.await();
            // основная рабочая фаза
            System.out.println(getName()+ " живи, вкалывай, сдохни (полезная работа)");
            Thread.sleep((long) (Math.random()*25000L));
        }
    }
}
