package SwordOffer;

public class No23_VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        int left = 0;
        int right = sequence.length - 1;

        return isBST(sequence, left, right);
    }

    public boolean isBST(int[] sequence, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = sequence[right];
        int i = 0;
        int pos = 0;
        for (i = left; i < right; i++) {
            if (root < sequence[i]) {
                pos = i;
                break;
            }
        }
        for (; i < right; i++) {
            if (root > sequence[i]) {
                return false;
            }
        }
        return isBST(sequence, left, pos) && isBST(sequence, pos + 1, right - 1);

    }
}
