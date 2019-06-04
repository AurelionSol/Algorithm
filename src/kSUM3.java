import java.util.ArrayList;
import java.util.List;

public class kSUM3 {
    List<List<Integer>> totList = new ArrayList<>();
    public static void main(String[] args) {
        kSUM3 main = new kSUM3();
        int[] a = {10,3,1,1};
        System.out.println(main.getAns(a,3,5));

    }

    public int getAns(int[] a, int k, int target) {
        // write your code here
        List<Integer> odd = new ArrayList();
        List<Integer> even = new ArrayList();
        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
                even.add(a[i]);
            }else{
                odd.add(a[i]);
            }
        }
        f(odd,k);
        f(even,k);
        int count = 0;
        for (int i = 0; i <totList.size() ; i++) {
            List<Integer> temp = totList.get(i);
            int sum=0;
            for (int j = 0; j < temp.size(); j++) {
                sum+=temp.get(j);
            }
            if (sum==target) count++;
        }
        return  count;
    }

    public void f(List<Integer> list,int k) {
        // write your code here
        List<Integer> temp = new ArrayList<>();
        dfs(temp,0,list,k);
    }

    public void dfs(List<Integer> temp,int index,List<Integer> nums,int k ) {
        // write your code here
        if(k==0) {
            totList.add(new ArrayList<>(temp));
        }
        for (int i = index; i <nums.size() ; i++) {
            temp.add(nums.get(i));
            dfs(temp,i+1,nums,k-1);
            //恢复现场
            temp.remove(temp.size()-1);
        }
    }
}
