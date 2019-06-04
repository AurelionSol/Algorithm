import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] a = {9, 3, 3, 1, 7, 5, 8};
        int[] b = {17, 35, 25, 1, 1, 15, 25, 25, 5, 19};
        System.out.println((a.toString()));

    }

    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> totList = new ArrayList();
        TreeNode flag = root;
        LinkedList<TreeNode> deque = new LinkedList();
        deque.offerFirst(root);
        ListNode node = new ListNode(-1);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.peekFirst();
            deque.offerFirst(temp.left);
            deque.offerFirst(temp.right);
            node.next = new ListNode(temp.val);
            if (temp == flag) {
                totList.add(node.next);
                node = new ListNode(-1);
                flag = deque.peekLast();
            }
            deque.pollFirst();
        }
        return totList;
    }


    public int leastInterval(char[] tasks, int n) {
        // write your code here

        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) - 1);
            } else {
                map.put(tasks[i], 1);
            }
        }
        int count = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (map.size() <= n) {
                count += n + 1 - map.size();
            }
            int index = map.get(tasks[i]);
            if (index == 0) map.remove(tasks[i]);
            map.put(tasks[i], map.get(tasks[i]) - 1);
            count++;
        }
        return count;

    }

    public long doingHomework(int[] cost, int[] val) {
        // Write your code here.
        int[] tot = new int[cost.length];
        int last = 0;
        for (int i = 0; i < cost.length; i++) {
            tot[i] = last + cost[i];
            last = tot[i];
        }
        long sum = 0;
        for (int i = 0; i < val.length; i++) {
            int left = 0, right = tot.length - 1, mid = 0;
            int ans = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (val[i] >= tot[mid]) {
                    ans = tot[mid];
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sum += ans;
        }
        return sum;
    }

    public int getDistance(int n, int m, int target, List<Integer> d) {
        // Write your code here.
        if (n == 0) return target;
        int l = 0, r = target, mid = 0, ans = 0;
        d.add(target);
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (check(n, m, target, mid, d)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int n, int m, int target, int mid, List<Integer> d) {
        // Write your code here.
        int last = 0, cnt = 0;

        for (int i = 1; i < n; i++) {
            if (d.get(i) - last < mid)
                cnt++;                   //比最大距离小就删除这个石头
            else
                last = d.get(i);
        }


        if (cnt > m)                //如果要删除的石头数比规定的多那么这个距离是失败的
            return false;
        return true;


    }

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public int getAns(List<Interval> a) {
        // write your code here
        if (a.size() == 0) return 0;
        Collections.sort(a, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end == o2.end) {
                    if (o1.start == o2.start) return 0;
                    return o1.start < o2.start ? 1 : -1;
                }
                return o1.end > o2.end ? 1 : -1;

            }
        });

        int end = -1;
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).start > end) {
                count++;
                end = a.get(i).end;
            }
        }
        return count;
    }

    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[right] > k) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            while (left < right && nums[left] <= k) left++;
            nums[right] = temp;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                return i;
            }
        }
        return nums.length;
    }

    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = n; i < nums.length; i++) {
            if (nums[i] > minHeap.element()) {
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.element();

    }


    public int kthSmallest(int k, int[] nums) {
        // write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxHeap.element()) {
                maxHeap.remove();
                maxHeap.add(nums[i]);
            }
        }
        return maxHeap.element();

    }

    public void sortIntegers2(int[] A) {
        // write your code here
        qSort(A, 0, A.length - 1);

    }

    public void qSort(int[] A, int left, int right) {
        if (A.length == 0) {
            return;
        }
        int pos;
        if (left < right) {
            pos = partition(A, left, right);
            qSort(A, left, pos - 1);
            qSort(A, pos + 1, right);
        }
    }

    public int partition(int[] A, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = A[mid];
        A[mid] = A[left];
        A[left] = pivot;
        while (left < right) {
            while (left < right && A[right] > pivot) right--;
            A[left] = A[right];
            while (left < right && A[left] < pivot) left++;
            A[right] = A[left];
        }
        A[left] = pivot;
        return left;
    }


}
