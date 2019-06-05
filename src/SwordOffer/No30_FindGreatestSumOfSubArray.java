package SwordOffer;

public class No30_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
            if (sum < array[i]) sum = array[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
