package concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PrintAB {
    //声明boolean变量用来控制打印
    private boolean flag = false;



//打印A

    public synchronized void printA() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("A");
        flag = true;
        notify();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//打印A

    public synchronized void printB() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("B");
        flag = false;
        notify();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//定义打印A的线程类

    class A implements Runnable {
        @Override
        public void run() {
// TODO Auto-generated method stub
            for (int i = 0; i < 10; i++) {
                printA();
            }
        }
    }

//定义打印B的线程类

    class B implements Runnable {
        @Override
        public void run() {
// TODO Auto-generated method stub
            for (int i = 1; i < 10; i++) {
                printB();
            }
        }
    }

    public static void main(String[] args) {
        PrintAB p = new PrintAB();
        Thread tA = new Thread(p.new A());
        Thread tB = new Thread(p.new B());
        tA.start();
        tB.start();

    }

}
