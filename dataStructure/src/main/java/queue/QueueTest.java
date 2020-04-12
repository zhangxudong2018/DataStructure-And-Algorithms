package queue;

import java.util.Scanner;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月16日 15:41:00
 * @place 公司
 * @copyright 张旭东
 */
public class QueueTest {
    public static void main(String[] args) {
//        ArrayQueue queue = new ArrayQueue(3);
        // 环形队列测试
        CircleArrayQueue queue = new CircleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        char input = ' ';
        boolean loop = true;
        while (loop){
            System.out.println("s(show)，显示队列");
            System.out.println("e(exit)，退出程序");
            System.out.println("a(add)，添加数据");
            System.out.println("g(get)，取出数据");
            System.out.println("h(head)，查看队列头数据");
            input = scanner.next().charAt(0);
            switch (input){
                case 's':
                    queue.printQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.printf("取出的数据是：%d\n" ,result);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.println("头数据是：" + result);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}
