package ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserLike {
    public static void main(String[] args) {
        UserLike m = new UserLike();
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int like = sc.nextInt();
            if (!map.containsKey(like)) {
                map.put(like, new ArrayList<>(i));
            }
            map.get(like).add(i);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            m.getCount(map, l, r, k);
        }
    }

    public  void getCount(HashMap<Integer, List<Integer>> map, int l, int r, int k) {
        if (!map.containsKey(k)) return;
        List<Integer> temp = map.get(k);
        int left = bSercher(temp, l);
        int right = bSercher(temp, r);
        if (right < map.get(k).size() && map.get(k).get(right) == r)
            System.out.println(right - left + 1);
        else
            System.out.println(right - left);
    }

    public  int bSercher(List<Integer> temp, int num) {
        int left = 0, right = temp.size() - 1, mid = 0, ans = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (temp.get(mid) > num)
                right = mid - 1;
            else if (temp.get(mid) < num)
                left = mid + 1;
            else
                return mid;
        }
        return left;
    }
}
