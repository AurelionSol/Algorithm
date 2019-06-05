package SwordOffer;

public class No9_JumpFloorII {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
    public static  int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }
}
