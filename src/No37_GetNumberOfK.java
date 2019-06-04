public class No37_GetNumberOfK {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3};
        int k = 3;
        System.out.println(GetNumberOfK(array, k));
        System.out.println("Hello World!");
    }

    public static int GetNumberOfK(int[] array, int k) {
        int len = array.length;
        int count = 0;
        int mid = find(array, k);
        if (mid == -1) return count;
        count++;
        for (int i = mid-1; i >= 0; i--) {
            if (array[i] == k) {
                count++;
            }
        }
        for (int i = mid + 1; i < len - 1; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }

    public static int find(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == k) return mid;
            else if (array[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
