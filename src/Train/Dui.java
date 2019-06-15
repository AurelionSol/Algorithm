package Train;

public class Dui {
    int[] data;
    int size;

    public Dui(int size) {
        this.data = new int[size + 1];
        this.size = size;
    }

    public void push(int num) {
        int i = size++;
        data[size] = num;
        while (i > 1 && data[i] > data[i / 2]) {
            swap(i, i / 2);
            i /= 2;
        }

    }

    public int pop() {
        if (size < 1) return -1;
        int ret = data[1];
        data[1] = data[size--];
        int i = 1;
        while (i * 2 <= size) {
            int j = i * 2;
            if (j + 1 <= size && data[j] < data[j + 1]) {
                j = j + 1;
            }
            swap(i, j);
            i = j;
        }
        return ret;
    }

    private void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
