package Train;

public class DanLi {
    private volatile static DanLi instance;

    private DanLi() {

    }

    public static DanLi getInstance() {
        if (instance == null) {
            synchronized (DanLi.class) {
                if (instance == null) {
                    instance = new DanLi();
                }
            }
        }
        return instance;
    }
}
