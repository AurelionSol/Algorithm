package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopK {
    public int[] topk(int[] nums, int k) {
        // write your code
        if(k>nums.length) return nums;
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        int [] ans = new int[k];
        for (int i = 0; i <nums.length ; i++) {
            maxHeap.offer(nums[i]);
        }
        for (int i = 0; i <k ; i++) {
            ans[i]=maxHeap.poll();
        }
        return  ans;
    }
}
