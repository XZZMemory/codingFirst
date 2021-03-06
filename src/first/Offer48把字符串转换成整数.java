package first;

import java.util.Scanner;

//不使用字符串转换成数字的库函数
public class Offer48把字符串转换成整数 {
    public static int flag = 0;//类常量0-正常 1-字符串空 2-非法输入

    public static void main(String[] args) {
        System.out.println("请输入一个整数字符串：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        int data = strToInt(str);
        if (flag == 1 || flag == 2) {
            System.out.println("非法数据！");
        }
        System.out.println("返回数据是：" + data);

    }

    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            flag = 1;
            return 0;
        }
        int num = 0;
        boolean numFlag = false;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (i == 0) {
                if (currentChar == '-') {
                    numFlag = true;
                } else if (currentChar == '+') ;
                else if (currentChar >= '0' && currentChar <= '9') {
                    num = num * 10 + (int) currentChar - (int) '0';
                } else//非法数据，结束程序
                {
                    flag = 2;
                    return 0;
                }
            } else {
                if (currentChar >= '0' && currentChar <= '9') {
                    num = num * 10 + (int) currentChar - (int) '0';
                } else//非法数据，结束程序
                {
                    flag = 2;
                    return 0;
                }
            }
        }
        if (numFlag == true) {
            num = -num;
        }
        return num;
    }
}
