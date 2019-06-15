package Train;

import MyStructure.QuickSort;

import java.util.LinkedList;

public class KuaiPai {

    public void qSort(int[] num, int l, int r) {
        if (num.length <= 0 || l < r || l < 0 || r > num.length) return;
        int pos = partition(num, l, r);
        qSort(num, l, pos - 1);
        qSort(num, pos + 1, r);

    }

//    public void qSortStack(int[] num, int l, int r) {
//        if (num.length <= 0 || l < r || l < 0 || r > num.length) return;
//        LinkedList<QuickSort.Record> stack = new LinkedList<>();
//        int pos = partition(num, l, r);
//        if (pos - 1 > l) stack.push(new QuickSort.Record(l, pos - 1));
//        if (pos + 1 < r) stack.push(new QuickSort.Record(pos + 1, r));
//        while (!stack.isEmpty()) {
//            QuickSort.Record record = stack.pop();
//            pos = partition(num, record.left, record.right);
//            if (pos - 1 > l) stack.push(new QuickSort.Record(l, pos - 1));
//            if (pos + 1 < r) stack.push(new QuickSort.Record(pos + 1, r));
//        }
//    }

    public int partition(int[] num, int l, int r) {
        int ranNum = (int) (Math.random() * (r - l) + l);
        int pivot = num[ranNum];
        num[ranNum] = num[l];
        num[l] = pivot;

        while (l < r) {
            while (l < r && num[r] > pivot) r--;
            num[l] = num[r];
            while (l < r && num[l] < pivot) l++;
            num[r] = num[l];
        }
        num[l] = pivot;
        return l;
    }
}
