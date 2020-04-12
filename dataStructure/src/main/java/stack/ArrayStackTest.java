package stack;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月18日 11:51:00
 * @place 公司
 * @copyright 张旭东
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.list();
        stack.pop();
        stack.list();
    }
}
