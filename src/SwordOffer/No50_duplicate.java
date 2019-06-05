package SwordOffer;

public class No50_duplicate {
    public static void main(String[] args) {
        int[] nums={2,1,3,1,4};
        int length = 5;
        int[] duplication=new int[0];
        System.out.println("Hello World");
    }

    //用原数组标记
    public boolean duplicateNoSpace(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[index]++;
                return true;

            }
            numbers[index] = numbers[index] + length;
        }
        duplication[0] = -1;
        return false;
    }

    //额外数组
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (length == 0) {
            duplication[0] = -1;
            return false;
        }
        int[] nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[numbers[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }
}
