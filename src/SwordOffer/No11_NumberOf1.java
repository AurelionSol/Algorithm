package SwordOffer;

public class No11_NumberOf1 {
    public static void main(String[] args) {

        System.out.println(NumberOf1(-1));
        System.out.println(NumberOf1Bit(-1));
    }
    public static int NumberOf1(int n) {
        int count=0;
        int num=n;
        byte[] bits=new byte[32];
        for(int i =bits.length-1;i>=0;i--){
            if(n%2==0) bits[i]=0;
            else {bits[i]=1; count++;}
            n/=2;
        }
        if(num<0){
            count=0;
            for (int i = 0; i <bits.length ; i++) {
                if (bits[i]==1){
                    bits[i]=0;
                }else {
                    bits[i]=1;
                }
            }
            bits[bits.length-1]++;
            for (int i = bits.length-1; i>0 ; i--) {
                if (bits[i]==2){
                    bits[i]=0;
                    bits[i-1]++;
                }
            }
            if (bits[0]==2){
                bits[0]=0;
            }
            for (int i = 0; i <bits.length ; i++) {
               if (bits[i]==1){
                   count++;
               }
            }
        }

        return count;
    }
    //用与和右移位运算
    public static int NumberOf1Bit(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
