import java.util.Stack;

public class No20_StackMin {
    public static void main(String[] args) {
        No20_StackMin stackMin = new No20_StackMin();
        stackMin.push(3);
        System.out.println(stackMin.min());
        stackMin.push(4);
        System.out.println(stackMin.min());
        stackMin.push(2);
        System.out.println(stackMin.min());
        stackMin.push(3);
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.push(0);
        System.out.println(stackMin.min());
        System.out.println("Hello World!");
    }

    int min = 2147483647;
    int[] nums = new int[10];
    int count = 0;

    Stack<Integer> supStack = new Stack<>();


    public void push(int node) {
        if (node < min) {
            supStack.push(node);
            min = node;
        }
        nums[count] = node;
        count++;
        if (count > (nums.length / 2)) {
            int[] newNums = new int[nums.length * 2];
            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i];
            }
            nums = newNums;
        }
    }

    public void pop() {
        if (nums[count - 1] <= min) {
            nums[count - 1] = 0;
            count--;
            supStack.pop();
            min = supStack.peek();
        } else {
            nums[count - 1] = 0;
            count--;
        }

        if (count < (nums.length / 4) && nums.length >= 20) {
            int[] newNums = new int[nums.length / 2];
            for (int i = 0; i < newNums.length; i++) {
                newNums[i] = nums[i];
            }
            nums = newNums;
        }
    }

    public int top() {
        return nums[count];
    }

    public int min() {
        return min;
    }
}
