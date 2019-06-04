import javax.print.DocFlavor;
import java.util.*;

public class No27_Permutation {
    public static void main(String[] args) {
        No27_Permutation permutation = new No27_Permutation();
        int[] nums = {3,3,0,3};
        System.out.println(permutation.permuteUnique(nums));
        System.out.println("Hello World!");
    }

    static ArrayList<String> listTol = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return listTol;
        }
        if (str.length() == 1) {
            listTol.add(str);
            return listTol;
        }
        ArrayList<String> list = new ArrayList<>();
        list.add(str.substring(0, 1));
        ArrayList<String> list2 = new ArrayList<>();
        list2.add(str.substring(0, 1));

        for (int j = 1; j < str.length(); j++) {
            for (int i = 0; i < list.size(); i++) {
                String childStr = list.get(i);
                list2.addAll(insertAll(str.substring(j, j + 1), new StringBuilder(childStr)));
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                String s = it.next();
                if (s.length() <= j) {
                    it.remove();
                }
            }
            list =new ArrayList<>(list2) ;
        }
        //去重复
        listTol=new ArrayList<>(list);
        Iterator<String> it = listTol.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() < str.length()) {
                it.remove();
            }
        }
        ArrayList<String> listTemp = new ArrayList();
        for (int i = 0; i < listTol.size(); i++) {
            if (!listTemp.contains(listTol.get(i))) {
                listTemp.add(listTol.get(i));
            }
        }
        //排序
        Collections.sort(listTemp);
        return listTemp;
    }

    public static ArrayList<String> insertAll(String c, StringBuilder builder) {
        ArrayList<String> list = new ArrayList<>();
        String temp = builder.toString();
        int len = builder.length();
        for (int i = 0; i < len; i++) {
            String newStr = insertStr(c, i, new StringBuilder(builder.toString()));
            list.add(newStr);
        }
        String newStr = temp + c;
        list.add(newStr);
        return list;
    }

    public static String insertStr(String c, int index, StringBuilder builder) {
        builder.insert(index, c);
        return builder.toString();
    }

    //--------------------------------------------------------------------------真实的全排列


    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> list = new ArrayList();
        f(list,nums,0,nums.length-1);
        return list;
    }

    public void f(List<List<Integer>> list,int[] nums,int from,int to){
        if(to < 0 || from <0 || nums == null || nums.length==0) {
            list.add(new ArrayList());
        }
        if(from==to) {
            List<Integer> temp = new ArrayList();
            for (int i =0; i<nums.length ;i++ ){
                temp.add(nums[i]);
            }
            list.add(temp);
        }
        else{
            for(int i =from;i<=to;i++){
                swap(nums,from,i);
                f(list, nums,from+1, to);
                swap(nums,from,i);
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
    //---------------------------------------------不包含重复的全排列

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> totList = new ArrayList();
        if (nums == null) {
            return totList;
        }
        if (nums.length == 0) {
            totList.add(new ArrayList<Integer>());
            return totList;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        helper(nums,list,totList,visited);
        return totList;

    }
    public void helper(int[] nums,List<Integer> list,List<List<Integer>> totList,int[] visited){
        if(list.size()==nums.length){
            totList.add(new ArrayList<>(list));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(visited[i]==1|| (i != 0 && nums[i - 1] == nums[i] && visited[i - 1] == 0)){
                continue;
            }
            list.add(nums[i]);
            visited[i] = 1;
            helper(nums, list, totList, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
