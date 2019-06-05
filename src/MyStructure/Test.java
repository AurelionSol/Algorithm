package MyStructure;

import java.util.LinkedList;

public class Test {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> supStack = new LinkedList<>();
    int min = Integer.MAX_VALUE;
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(number<=min){
            min = number;
            supStack.push(number);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int temp = stack.pop();
        if(temp==min){
            supStack.pop();
            if(!supStack.isEmpty()){
                min = supStack.peek();
            }else {
                min = Integer.MAX_VALUE;
            }
        }
        return  temp;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return  min;
    }

}
