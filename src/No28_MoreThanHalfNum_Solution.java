import java.util.ArrayList;

public class No28_MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution2(nums));
        System.out.println("Hello World!");
    }
    public static int MoreThanHalfNum_Solution2(int[] array) {
        int count=1;
        int soldier=array[0];
        for (int i = 1; i <array.length ; i++) {
            if (array[i]==soldier){
                count++;
            }else {
                count--;
            }
            if (count==0){
                soldier=array[i];
                count++;
            }
        }
        count=0;
        for (int i = 0; i < array.length; i++) {
            if (soldier==array[i]){
                count++;
            }
        }
        return  count>(array.length/2)?soldier:0;
    }


    public static int MoreThanHalfNum_Solution(int[] array) {
        int[] nums = new int[array.length+1];
        int len = array.length / 2;
        int count = 0;
        for (int i = 0; i < array.length; i++) {

            boolean flag = false;
            for (int j = 0; j < len+1; j++) {
                if (array[i] == nums[j]) {
                    nums[j + len+1]++;
                    flag = true;
                }
            }
            if (!flag) {
                nums[count] = array[i];
                count++;

            }
        }
        for (int i = len+1; i < nums.length; i++) {
            if (nums[i] >= len) {
                return nums[i - len-1 ];
            }
        }
        return 0;
    }
}
