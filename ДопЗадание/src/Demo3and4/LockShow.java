package Demo3and4;

public class LockShow {

    public static void main(String[] args) throws Exception {
        Account account = new Account(0);

        new VKThread(account).start();

        System.out.println("enter work");

        account.waitAndWithdraw(50000000);

        System.out.println("end stat = " + account.getStats());
    }


    private static class VKThread extends Thread {

        private final Account account;

        private VKThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 60000000; ++i) {
                account.cheatViews(1);
            }
        }
    }

}
