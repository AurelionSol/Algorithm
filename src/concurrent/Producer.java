package concurrent;

public class Producer implements Runnable {
    private int count = 0;
    private Shop s;

    public Producer(Shop s) {
        this.s = s;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (s.product != null) wait();
                }
                if (++count == 10) {
                    System.out.println("closing");
                    s.exec.shutdownNow();
                }
                System.out.println("Product!");
                synchronized (s.consumer) {
                    s.product = new Product(count);
                    s.consumer.notifyAll();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted!");
            e.printStackTrace();
        }
    }
}
