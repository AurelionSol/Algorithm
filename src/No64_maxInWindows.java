import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class No64_maxInWindows {
    //用双端队列
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 0) return list;
        if (size == 0) return list;
        if (size > num.length) return list;
        //队列中存的是下标,队列头永远是当前窗口最大值
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < size - 1; i++) {
            while (q.size() > 0 && num[q.peekLast()] <= num[i])
                q.removeLast();
            q.addLast(i);
        }
        //
        for (int i = size - 1; i < num.length; i++) {
            while (q.size() > 0 && num[q.peekLast()] <= num[i])
                q.removeLast();
            q.addLast(i);
            list.add(num[q.peekFirst()]);
            //因为存的是下标，当最大值过期
            if (i - size + 1 == q.peekFirst())
                q.removeFirst();
        }
        return list;
    }
}
