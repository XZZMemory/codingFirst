package first;

//输入一个整数数组，实现一个函数来调整数组中数字的顺序使得所有奇数位于数组的前半部分 ，所有偶数位于数组的后半部分
//                                            使得数组中的数按照大小分为两部分，所有的负数均位于非负数的前面
//                                            能被3整除的数都在不能被3整除的数前面
//若需要实现这三个函数，则考虑扩展性，在这个模式下方便的把已有的解决方案扩展到同类型的问题上
//********  可扩展性*`解耦，可以提高代码的重用性**************
public class Offer14调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] number = {1, -3, 4, -5, 6, 7, 8, 9};
        record(number);
    }

    public static void record(int[] number) {//奇数在前，偶数在后
        int pBegin = 0;
        int pEnd = number.length - 1;
        for (; pBegin < pEnd; pBegin++, pEnd--) {
            while ((pBegin < pEnd) && (funEven(number, pBegin)))
                pBegin++;
            while ((pBegin < pEnd) && (!funEven(number, pEnd)))
                pEnd--;
            if (pBegin < pEnd) {
                int temp;
                temp = number[pBegin];
                number[pBegin] = number[pEnd];
                number[pEnd] = temp;
            }
        }
    }

    //是不是偶数，用位运算，而不是用* / % 运算
    public static boolean funEven(int[] number, int i) {
        if ((number[i] & 1) == 0)
            return true;
        return false;
    }

    public static boolean funNegative(int[] number, int i) {
        if (number[i] < 0)
            return true;
        return false;
    }

    public static boolean funOf3(int[] number, int i) {
        if (number[i] % 3 == 0)
            return true;
        return false;
    }

    //可扩展性低，而且使用的是% 运算，运算效率低
    public static void recorderOddEven(int[] number) {
        int pBegin = 0;
        int pEnd = number.length - 1;
        for (; pEnd > pBegin; pBegin++, pEnd--) {
            while ((pBegin < pEnd) && (number[pBegin] % 2 == 0))//前面应该是奇数
                pBegin++;
            while ((pBegin < pEnd) && (number[pEnd] % 2 == 1))//后面应该是偶数
                pEnd--;
            if (pBegin < pEnd) {
                int temp = number[pBegin];
                number[pBegin] = number[pEnd];
                number[pEnd] = temp;
            }
        }
    }
}
