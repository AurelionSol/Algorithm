package Train;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShangDian {
    ChanPing c;
    XiaoFeiZhe xfz = new XiaoFeiZhe(this);
    ShengChanZhe scz = new ShengChanZhe(this);
    ExecutorService service = Executors.newCachedThreadPool();

    public ShangDian() {
        service.execute(xfz);
        service.execute(scz);
    }
    public static void main(String[] args) {
        new ShangDian();
    }
}
