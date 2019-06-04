import java.util.ArrayList;

public class No42_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
       while (left<right){
           int temp = array[left]+array[right];
           if (temp<sum){
               left++;
           }
           if (temp>sum){
               right--;
           }
           if (temp==sum){
               list.add(array[left]);
               list.add(array[right]);
               return list;
           }
       }
       return list;
    }
}
