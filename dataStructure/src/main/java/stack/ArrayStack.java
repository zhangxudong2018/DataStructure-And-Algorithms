package stack;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function    用数组实现栈
 * @date 2019年12月18日 11:50:00
 * @place 公司
 * @copyright 张旭东
 */
public class ArrayStack {

    /**
     * 栈最大容量
     */
    private int maxSize;

    /**
     * 数组实现栈，存数据
     */
    private int[] stack;

    /**
     * 栈顶。初始化-1
     */
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断栈是否满
     * @return
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈
     */
    public void push(int value){
        if (isFull()){
            throw new RuntimeException("栈已满，不能入栈");
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，不能出栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 数字越大，优先级越高
     * 暂时只有+,-,* ,/
     * @param operator
     * @return
     */
    public int priority(int operator){
        if (operator == '*' || operator == '/'){
            return 1;
        }else if(operator == '+' || operator == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 返回栈顶的数据
     * @return
     */
    public int peek(){
        return stack[top];
    }

    /**
     * 判断是否是运算符
     * @param val
     * @return
     */
    public boolean isOperator(int val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
    public int calculator(int num1, int num2, int operator){
        int result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }

    /**
     * 遍历
     */
    public void list(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i >= 0; i--){
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
