package tooffer;
import java.util.Scanner;
import java.util.Stack;

public class Offer7用两个栈实现队列 {
    public static void main(String[] args)
    {
        System.out.println("请输入操作，1-进队列，2-出队列,3-退出");
        Stack<Integer> stack1=new Stack<Integer>();
        Stack<Integer> stack2=new Stack();
        int[] operationList={1,2,3};
        Scanner in;
        in=new Scanner(System.in);
        int i;
        i=in.nextInt();
        while(i!=3)
        {
                if(IsContain(operationList,i))
                {
                    switch (i)
                    {
                        case 1://进栈
                            System.out.println("请输入进栈数据");
                            Scanner Data=new Scanner(System.in);
                            int data=Data.nextInt();
                            InQueue(stack1,data);
                            break;
                        case 2://出栈
                            DeQueue(stack1,stack2);
                            break;

                    }
                System.out.println("请输入操作，1-进栈，2-出栈,3-退出");

                }
                else
                    System.out.println("输入数字不正确，请输入操作，1-进栈，2-出栈,3-退出");
                in=new Scanner(System.in);
                i=in.nextInt();

        }
        if(i==3)
        {
            System.out.println("退出程序");
        }


    }
    public static boolean IsContain(int[] list,int a)
    {
        boolean flag=false;
        for (int i=0;i<list.length;i++)
        {
            if (list[i]==a)
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
    //进栈
    public static void InQueue(Stack stack1, int data)
    {
        System.out.println("执行进栈操作");
        if(stack1.size()==stack1.capacity())
        {
            System.out.println("栈已满，请先出栈");
        }
        else
            stack1.push(data);
        System.out.println("进栈数据是："+stack1.lastElement());
    }
    //出栈
    public static void DeQueue(Stack stack1, Stack stack2)
    {
        System.out.println("执行出栈操作");
        if(stack2.isEmpty())//第二个栈是空的，已经没有数据了
        {
            if (stack1.isEmpty())
                System.out.println("栈空，请先进栈");
            else//栈1的数据需要进入栈2
            {
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
                System.out.println("出栈元素是："+stack2.pop());
            }
        }
        else
            System.out.println("出栈元素是："+stack2.pop());
    }

}
