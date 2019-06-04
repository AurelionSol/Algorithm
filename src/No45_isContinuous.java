import java.util.Arrays;

public class No45_isContinuous {
    public boolean isContinuous(int[] numbers) {
        int len = numbers.length;
        if (len == 0) return false;
        int max = -1;
        int min = 14;
        int bitFlag = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) continue;
            if (((bitFlag >> numbers[i]) & 1) == 1) return false;
            bitFlag |= (1 << numbers[i]);
            if (numbers[i] > max) max = numbers[i];
            if (numbers[i] < min) min = numbers[i];

        }
        return (len - 1) >= (max - min);
    }
}
