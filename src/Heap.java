import java.util.*;

public class Heap {
    //堆是完全二叉树，用数组保存
    int[] data;
    int size;


    // 默认实现了一个最小堆。
    Queue<Integer> minHeap = new PriorityQueue<>();

    // 实现最大堆
    Queue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    });


    public static void main(String[] args) {
        Random random = new Random();
        Heap heap = new Heap(16);
        for (int i = 0; i < 10; i++) {
            heap.push((int) (1 + Math.random() * 100));
        }
        System.out.println(Arrays.toString(heap.data));
        for (int i = 0; i < 10; i++) {
            System.out.println(heap.pop());
        }
    }

    public Heap(int capacity) {
        this.data = new int[capacity + 1];
        this.size = 0;
    }

    public void push(int num) {
        int i = size++;
        data[size] = num;
        while (i > 1 && data[i] > data[i / 2]) {
            swap(data, i, i / 2);
            i /= 2;
        }
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        int ret = data[1];
        data[1] = data[size--];
        int i = 1;
        while (i * 2 <= size) {
            int j = i * 2;
            if (j + 1 <= size && data[j] < data[j + 1]) {
                j += 1;
            }
            if (data[i] > data[j]) break;
            swap(data, i, j);
            i = j;
        }
        return ret;
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


}
