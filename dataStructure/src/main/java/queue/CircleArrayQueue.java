package queue;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 数组实现环形队列，预留一个空间
 *              思路： front指向队列的第一个元素,即arr[front]为第一个元素，初始值为0；
 *                     rear指向队列的最后一个元素，初始值为0；
 *                     队列满的条件是 front = (rear + 1) % maxSize；
 *                     队列为空的条件是 front = rear；
 *                     队列有效数据的个数 (rear + maxSize - front) % maxSize
 * @date 2019年12月16日 18:07:00
 * @place 公司
 * @copyright 张旭东
 */
public class CircleArrayQueue {

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
     * 初始化
     * @param maxSize
     */
    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return front == (rear + 1) % maxSize;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
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
        arr[rear] = n;
        // 考虑取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列数据，出队列
     * @return
     */
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        // 将数据保存到临时变量
        int value = arr[front];
        // front后移
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 输出队列
     */
    public void printQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        // 思路：从front开始，遍历元素个数
        for (int i = front; i < front + size(); i++){
            System.out.printf("arr[%d] = %d\n",(i % maxSize),arr[(i % maxSize)]);
        }
    }

    /**
     * 获取当前队列数据有限个数
     * @return
     */
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列头数据
     * @return
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return arr[front];
    }
}
