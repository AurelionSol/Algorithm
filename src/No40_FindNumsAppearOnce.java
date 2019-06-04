import java.util.HashMap;

public class No40_FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = {0};
        int[] num2 = {0};
        FindNumsAppearOnce(nums, num1, num2);
        System.out.println("Hello World!");
    }
    //用异或做，可以用位运算实现，如果将所有所有数字相异或，则最后的结果肯定是那两个只出现一次的数字异或

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int time = map.get(array[i]);
                map.put(array[i], ++time);
            } else {
                map.put(array[i], 1);
            }
        }
        boolean hasOne = false;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (hasOne)
                    num2[0] = array[i];
                else {
                    num1[0] = array[i];
                    hasOne = true;
                }

            }
        }
    }
}
