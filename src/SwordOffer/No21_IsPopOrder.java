package SwordOffer;

import java.util.Stack;

public class No21_IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        int[] popB = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(pushA, popA));
        System.out.println(IsPopOrder(pushA, popB));
        System.out.println("Hello World!");
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int i = 0;
        while (count < popA.length && i < pushA.length) {
            stack.push(pushA[i]);
            if (pushA[i] == popA[count]) {
                stack.pop();
                count++;
            }
            i++;
        }
        for (int j = count; j <popA.length ; j++) {
            if (stack.peek()==popA[j]){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
