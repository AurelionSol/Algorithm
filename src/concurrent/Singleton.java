package concurrent;

public class Singleton {
    //这里volatile的作用仅仅是阻止指令重排序,初始化对象的指令可能会被重排序，
    // 如果已经分配内存，但未初始化对象，此时另一个线程访问则会报错
    private volatile static Singleton instance;

    private Singleton() {

    }

    //这个版本的代码看起来有点复杂，注意其中有两次if (instance == null)的判断，这个叫做『双重检查 Double-Check』。
    //第一次检查只有null才会进入同步，减少同步开销，第二次检查防止出现多个实例
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

}
