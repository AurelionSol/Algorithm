package Train;

public class XiaoFeiZhe implements Runnable {
    ShangDian s;

    public XiaoFeiZhe(ShangDian s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (s.c == null) wait();
                }
                System.out.println("消费"+s.c.toString());
                synchronized (s.scz) {
                    s.c = null;
                    s.scz.notifyAll();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
