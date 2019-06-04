public class No13_reOrderArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(array);
        for (int i :
                array) {
            System.out.println(i);
        }

    }

    //插入排序：O(n^2)+O(1)，另外开辟数组：O(n)+O(n)
    public static void reOrderArray(int[] array) {
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int oddcount = 0;
        int evencount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even[evencount] = array[i];
                evencount++;
            } else {
                odd[oddcount] = array[i];
                oddcount++;
            }
        }
        int index = 0;
        while (oddcount > 0) {
            array[index] = odd[index];
            oddcount--;
            index++;
        }
        for (int i = 0; i < evencount; i++) {
            array[index + i] = even[i];
        }

    }
}
