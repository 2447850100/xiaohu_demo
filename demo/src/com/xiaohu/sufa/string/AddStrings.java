package com.xiaohu.sufa.string;

public class AddStrings {
    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String s = addStrings.addStrings("0", "0");
        System.out.println("s = " + s);
    }

    public String addStrings(String num1, String num2) {

        StringBuilder result = new StringBuilder();
        //获取两指针初始位置
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        //定义一个保存进位的数
        int carry = 0;

        int sum;
        //没有补0
        while (index1 >= 0 || index2 >= 0 || carry != 0) {

            int n1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int n2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;

            sum = n1 + n2 + carry;
            //result获取个位
            result.append(sum % 10);
            //取进位
            carry = sum / 10;
            //最后两指针向前移动
            index1--;
            index2--;
        }
        //反转最后result就是最后结果
        return result.reverse().toString();
    }
}
