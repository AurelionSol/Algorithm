package MyStructure;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class QuickSort {


    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100);
        }
        printNums(nums);
        qSort(nums, 0, nums.length - 1);
        System.out.println("``````````````````````````````````````");
        printNums(nums);
        qSortStack(nums, 0, nums.length - 1);
        System.out.println("``````````````````````````````````````");
        printNums(nums);
    }

    public static void qSort(int[] nums, int left, int right) {
        if (nums == null || left >= right || left < 0 || right >= nums.length) {
            return;
        }
        int pos = partition(nums, left, right);
        qSort(nums, left, pos - 1);
        qSort(nums, pos + 1, right);

    }

    public static int partition(int[] nums, int left, int right) {

        int ranNum = (int) (Math.random() * (right - left) + left);
        int pivot = nums[ranNum];
        nums[ranNum] = nums[left];
        nums[left] = pivot;
        while (left < right) {
            while (left < right && nums[right] > pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void printNums(int[] nums) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(nums[i * 10 + j] + ",");
            }
            System.out.println(" ");
        }
    }

    public static void qSortStack(int[] nums, int left, int right) {
        LinkedList<Record> stack = new LinkedList<>();
        if (nums == null || left < 0 || right >= nums.length) {
            System.out.println("error");
            return;
        }
        int pos;
        pos = partition(nums, left, right);
        if (pos - 1 > left) stack.push(new Record(left, pos - 1));
        if (pos + 1 < right) stack.push(new Record(pos + 1, right));
        while (!stack.isEmpty()) {
            Record record = stack.pop();
            pos = partition(nums, record.left, record.right);
            if (pos - 1 > record.left) stack.push(new Record(record.left, pos - 1));
            if (pos + 1 < record.right) stack.push(new Record(pos + 1, record.right));
        }

    }

    private static class Record {
        int left;
        int right;

        private Record(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


}
