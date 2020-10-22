package com.demo;

public class day03 {
    //给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
    public String multiply(String num1, String num2) {
//        若有一个乘数为0，则直接返回0
        if ("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        String ans = "0";

        int n1 = num1.length()-1;
        int n2 = num2.length()-1;

//        得到num2的每一个数
        for (int i = n2; i >=0; i--) {
            StringBuilder curr = new StringBuilder();
            int add = 0;
//            根据数的位数，加上0
            for (int j = n2; j >i ; j--) {
                curr.append("0");
            }
//            得到该位代表的数，并与num1进行相乘
            int y = num2.charAt(i)-'0';
            for (int j = n1; j >= 0 ; j--) {
                int x = num1.charAt(j)-'0';
                int res = x*y+add;
//                add用来进位
                add = res/10;
                curr.append(res%10);
            }
            //加上余数
            if (add!=0)
                curr.append(add);
            //因为都是append，最后要一次reverse
            ans = addString(ans,curr.reverse().toString());
        }
        return ans.toString();
    }

    public String addString(String num1,String num2){
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        int add = 0;
        StringBuffer sb = new StringBuffer();
//        将两个数相加合并，add用来记录进位
        while (l1>=0||l2>=0||add!=0){
            int x = l1>=0?num1.charAt(l1)-'0':0;
            int y = l2>=0?num2.charAt(l2)-'0':0;
            int res = x+y+add;
            add = res/10;
            sb.append(res%10);
            l1--;l2--;
        }
        sb.reverse();
        return sb.toString();
    }


    public String multiply2(String num1, String num2) {
        if ("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        //考虑极端情况：两个数的长度为m,n
        //1. 当两个数都最小时，相乘得到的长度大于等于m+n-1
        //2. 当两个数都最大时，相乘得到的长度小于m+n+1
        //故长度取m+n时，可以满足需求
        int[] result = new int[(l1+1)+(l2+1)];
        for (int i = l1; i >= 0 ; i--) {
            int x = num1.charAt(i)-'0';
            for (int j = l2; j >= 0 ; j--) {
                int y = num2.charAt(j)-'0';
                //每一位先乘上并相加
                result[i+j+1] += x*y;
            }
        }
        //进行进位运算
        for (int i = result.length-1; i >0; i--) {
            result[i-1] += result[i]/10;
            result[i] %= 10;
        }

        int index = result[0]==0?1:0;
        StringBuilder sb = new StringBuilder();
        while (index<result.length){
            sb.append(result[index]);
            index++;
        }
        return sb.toString();
    }

}
