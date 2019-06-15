package Train;

public class ShengChanZhe implements Runnable {
    ShangDian s;
    private int count = 0;

    public ShengChanZhe(ShangDian s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (s.c != null) wait();
                }
                if (++count == 10) {
                    s.service.shutdownNow();
                }
                System.out.println("生产");
                synchronized (s.xfz) {
                    s.c = new ChanPing(count);
                    s.xfz.notifyAll();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
