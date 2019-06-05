package SwordOffer;

import java.util.Arrays;

import java.util.LinkedHashMap;

public class No35_InversePairs {
    static int p = 0;

    public static void main(String[] args) {

        int[] nums = {5, 4, 6, 2, 1, 3, 8, 7, 9};
        System.out.println(InversePairs(nums));
        System.out.println("Hello World!");
    }



    public static int InversePairsMerge(int[] array) {
        if (array != null)
            sort(array, 0, array.length - 1);
        return p;
    }

//憨憨算法
    public static int InversePairs(int[] array) {
        int p = 0;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        Arrays.sort(array);
        int flag = 0;
        int sup = 0;
        for (int i = 0; i < array.length; i++) {
            if (i >= sup) {
                flag = 0;
            }
            int pos = map.get(array[i]);
            if (pos - i + flag > 0) {
                sup = pos;
                flag++;
                p = p + pos - i;
            }
        }
        return p;
    }

    public static int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                p += mid - i + 1;
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }
}


