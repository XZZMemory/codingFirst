package first;

public class Offer10二进制Excell {
    public static void main(String[] args) {
        String test1 = "A";
        String test2 = "AB";
        String test3 = "ZZ";
        String test4 = " ";
        String test5 = "A2";
        int test1num = getNum(test1);
        int test2num = getNum(test2);
        int test3num = getNum(test3);
        int test4num = getNum(test4);
        int test5num = getNum(test5);
        int test6num = getNum(null);
    }

    public static int getNum(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("字符串为空！");
            return -1;
        }
        char[] data = str.toCharArray();
        int num = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 'Z' || data[i] < 'A') {
                System.out.println("数据格式错误！");
                return -1;
            }
            int number = data[i] - 'A' + 1;
            num = num * 26 + number;
        }
        return num;
    }
}
