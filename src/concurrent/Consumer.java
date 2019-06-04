package concurrent;

public class Consumer implements Runnable{
    private Shop s;

    public Consumer(Shop s) {
        this.s = s;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (s.product==null) wait();
                }
                System.out.println("Consume!"+s.product);
                synchronized (s.producer){
                    s.product=null;
                    s.producer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted!");
            e.printStackTrace();
        }
    }
}
