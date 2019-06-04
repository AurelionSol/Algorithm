//题目描述
//将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
//要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。

//输入描述:
//输入一个字符串,包括数字字母符号,可以为空
//输出描述:
//如果是合法的数值表达则返回该数字，否则返回0

//示例1
//输入
//+2147483647
//    1a33

//输出
//2147483647
//    0

public class No49_StringToValue {
    public int StrToInt(String str) {
        int len =str.length();
        char charArr[]=new char[len];
        charArr=str.toCharArray();
        int num=0;
        //判断正负号
        boolean flag=true;
        for(int i=0;i<len;i++){
            if(i==0){
                //判断正负号
                if(charArr[i]=='+'||charArr[i]=='-'){
                    if(charArr[i]=='-'){
                        flag=false;
                    }
                    continue;
                }
            }
            //判断是否为数字
            if(charArr[i]<48 || charArr[i]>57)
                return 0;
            if(flag){
                num+=(charArr[i]-'0')*Math.pow(10,len-i-1);
            }else{
                num-=(charArr[i]-'0')*Math.pow(10,len-i-1);
            }


        }
        return num;
    }
}
