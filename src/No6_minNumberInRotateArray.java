public class No6_minNumberInRotateArray {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }

    public int minNumberInRotateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i]<array[0])return array[i];
        }
        return 0;
    }
}
