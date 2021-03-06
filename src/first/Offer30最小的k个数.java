//输入n个数，找出其中最小的k个数,输出的最小的几个数不要求排序
//一种常规的解法：对这几个数进行排序，排在前面的K个数就是最小的k个数
package first;

import java.util.Random;

public class Offer30最小的k个数 {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        findLeastNumbers(numbers, k);
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }

    /*当我们可以修改输入数组时，可以用这种方法,利用快排*/
    public static void findLeastNumbers(int[] numbers, int k) {
        if (numbers == null || k < 0 || k > numbers.length - 1) {
            System.out.println("输入的信息有误！");
            return;
        }
        int start = 0;
        int end = numbers.length - 1;
        int index = quickSort(numbers, start, end);
        while (index != k - 1) {
            if (index < k - 1)
                start = index;
            else if (index > k - 1)
                end = index;
            index = quickSort(numbers, start, end);
        }
    }

    /*快速排序*/
    public static int quickSort(int[] numbers, int start, int end) {
        if ((numbers == null) || (start < 0) || (end > numbers.length) || (start > end)) {
            System.out.println("输入的信息错误！");
            return 0;
        }
        Random random = new Random();
        int m = random.nextInt(end - start + 1) + start;
        int number = numbers[m];
        while (start < end) {
            while ((start < end) && (numbers[start] <= number)) {
                start++;
            }
            while ((start < end) && (numbers[end] > number)) {
                end--;
            }
            if (start < end) {
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
                ++start;
                --end;
            }
        }
        return start;
    }
}
