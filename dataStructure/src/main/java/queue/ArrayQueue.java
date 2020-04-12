package queue;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 使用数组模拟队列
 *             队列是有序列表，遵循先入先出原则
 * @date 2019年12月16日 15:25:00
 * @place 公司
 * @copyright 张旭东
 */
public class ArrayQueue {

    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 存放数据，模拟队列
     */
    private int[] arr;

    /**
     * 初始化队列
     * @param maxSize
     */
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        front = -1;         // 表示指向队列头的前一个位置
        rear = -1;          // 表示队列尾（即指向队列尾的数据）
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据
     * @param n
     */
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 获取队列数据，出队列
     * @return
     */
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    /**
     * 输出队列
     */
    public void printQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    /**
     * 显示队列头数据
     * @return
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return arr[front + 1];
    }
}
