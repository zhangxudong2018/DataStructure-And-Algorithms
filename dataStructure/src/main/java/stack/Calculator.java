package stack;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function    用栈实现表达式的计算
 *               思路：（1）用索引index扫描表达式
 *                     （2）如果是数字，直接入数栈
 *                     （3）如果是符号，需要分两种情况
 *                     （3.1）若当前符号栈为空，则将扫描到的符号直接入符号栈
 *                     （3.2）若当前符号栈不为空，将当前符号与栈中符号对比
 *                          如果当前符号的优先级小于或等于栈中符号，需要从数栈pop出两个数，从符号栈pop出一个符号进行运算，将结果压入数栈，在将当前符号压入符号栈；
 *                          如果当前符号的优先级大于栈中符号，直接压入符号栈
 *                     （4）当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数据进行运算
 *                     （5）最后在数栈中只有一个数，就是结果
 * @date 2019年12月18日 12:22:00
 * @place 公司
 * @copyright 张旭东
 */
public class Calculator {

    public static void main(String[] args) {
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        // 用于扫描的索引
        int index = 0;
        // 表达式
        String expression = "70+2*6-40";
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int result = 0;
        char ch = ' ';  // 将每次扫描到的char存放到ch
        String keepNum = "";    //用来拼接多位数
        while (true){
            ch = expression.substring(index,index+ 1).charAt(0);
            // 判断ch是什么
            if (operStack.isOperator(ch)){
                // 如果ch是运算符
                if (!operStack.isEmpty()){
                    // 比较优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        result = numStack.calculator(num1, num2, oper);
                        // 把运算结果入数栈
                        numStack.push(result);
                        // 把当前操作符入符号栈
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else {
                    // 栈为空就直接入栈
                    operStack.push(ch);
                }
            }else{
                // 扫描出来的是字符，要转成数字
                // 当数是多位数时，不能直接入数栈，需要看下一位是否是运算符
                keepNum += ch;
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if (operStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))){
                        // 如果后一位是运算符
                        numStack.push(Integer.parseInt(keepNum));
                        // 重要！！！！ keepNum清空
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()){
                break;
            }
        }
        // 当表达式扫描完毕，pop出相应数据进行计算
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            result = numStack.calculator(num1, num2, oper);
            numStack.push(result);
        }
        int value = numStack.pop();
        System.out.printf("表达式%s的结果为%d\n",expression,value);
    }
}
