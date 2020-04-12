package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function    逆波兰计算器（后缀表达式）
 * @date 2019年12月18日 13:55:00
 * @place 公司
 * @copyright 张旭东
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
//        String expression = "1+((2+3)*4)-5";
        // 24
        String expression = "12+((2+6)*3)-((6+4)/5)-10";
        List<String> list = toInFixExpressionList(expression);
        System.out.println(list);
        List<String> parseList = parseSuffixExpression(list);
        System.out.println(parseList);
        System.out.println("计算结果为：" + calculator(parseList));
    }

    /**
     * 将后缀表达式处理放入List中
     * @param suffixexpression
     * @return
     */
    public static List<String> getListString(String suffixexpression){
        List<String> list = new ArrayList<String>();
        String[] element = suffixexpression.split(" ");
        for (String ele : element){
            list.add(ele);
        }
        return list;
    }

    /**
     * 将中缀表达式处理放入List中
     * @param s
     * @return
     */
    public static List<String> toInFixExpressionList(String s){
        List<String> list = new ArrayList<String>();
        // 这是一个指针，用于遍历表达式
        int i = 0;
        String str; // 对多位数的拼接
        char ch;    // 遍历出的字符
        do{
            // 如果ch不是一个数字，加入到s1
            if ((ch = s.charAt(i)) < 48 || (ch = s.charAt(i)) > 57){
                list.add("" + ch);
                i++;
            }else {
                str = "";
                // 如果是数字，要考虑多位数的问题
                while (i < s.length() && (ch = s.charAt(i)) >= 48 && (ch = s.charAt(i)) <= 57){
                    str += ch;
                    i++;
                }
                list.add(str);
            }
        }while (i < s.length());
        return list;
    }

    /**
     * 将中缀表达式转成后缀表达式
     * 算法分析：
     *          （1）：初始化两个栈：运算符栈s1和储存中间结果的栈s2
     *          （2）：从左至右扫描中缀表达式;
     *          （3）：遇到数字时，压入s2；
     *          （4）：遇到运算符时，比较其与s1栈顶运算符的优先级（括号不算运算符）
     *              a)：如果s1为空，或栈顶为‘（‘，则直接将此运算符压入s1；
     *              b)：若优先级比栈顶运算符高，也将运算符压入s1；
     *              c）：否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4-a与s1中新的栈顶运算符比较
     *          （5）：遇到括号时：
     *              a）：如果是左括号，则直接压入s1；
     *              b）：如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
     *          （6）：重复步骤2-5，直到表达式最右边
     *          （7）：将s1中剩余的运算符依次弹出并压入到s2；
     *          （8）：依次弹出s2的元素并输出。此时为转换后的后置表达式
     * @param list
     * @return
     */
    public static List<String> parseSuffixExpression(List<String> list){
        // 定义符号栈
        Stack<String> s1 = new Stack<>();
        // 定义存储中间结果的集合
        List<String> s2 = new ArrayList<>();
        // 遍历list
        for (String item : list){
            if (item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                // 如果是右括号
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                // 将这个小括号弹出
                s1.pop();
            }else {
                while (s1.size() != 0 && Operator.getValue(s1.peek()) >= Operator.getValue(item)){
                    s2.add(s1.pop());
                }
                // 还需要将item压入s1
                s1.push(item);
            }
        }
        // 将s1中剩余的运算符依次弹出并压入到s2；
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 计算
     * @return
     */
    public static int calculator(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String item : list){
            if (item.matches("\\d+")){
                // 匹配多位数，并入栈
                stack.push(item);
            }else {
                // pop出两个数计算，并入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (item.equals("+")){
                    result = num1 + num2;
                }else if(item.equals("-")){
                    result = num1 - num2;
                }else if(item.equals("*")){
                    result = num1 * num2;
                }else if(item.equals("/")){
                    result = num1 / num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                // 把结果入栈
                stack.push("" + result);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

/**
 * 用来比较操作符的类
 */
class Operator{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String oper){
        int result = 0;
        switch (oper){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
