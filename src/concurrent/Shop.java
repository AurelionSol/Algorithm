package concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Shop {
    //商店中有商品
    Product product;
    //创建一个线程池
    ExecutorService exec = Executors.newCachedThreadPool();
    //
    Consumer consumer = new Consumer(this);
    Producer producer = new Producer(this);

    public Shop() {
        exec.execute(producer);
        exec.execute(consumer);
    }

    public static void main(String[] args) {
        new Shop();
    }

}
