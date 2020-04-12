package recursive;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function     八皇后问题：在一个8*8的棋盘中，任意两个皇后不能再同一行，同一列，同斜线，问有多少种摆法（92种）
 *                回溯算法思路分析：
 *                              （1）：第一个皇后先放在第一行第一列
 *                              （2）：第二个皇后放在第二行第一列，然后判断是否OK，如果不OK，继续放在第二列，依次把所有列放完，找一个合适的
 *                              （3）：继续放第三个皇后，也依次判断，如果冲突，继续放，直到合适
 *                              （4）：当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后放在第一列的所有解全部得到
 *                              （5）：继续回头将第一个皇后放在第二列，循环指向1-4步骤
 * @place 公司
 * @copyright 张旭东
 */
public class Queue8 {

    // 定义棋盘中共有多少个皇后
    static int max = 8;
    // 定义一个数组，保存放置结果，比如：{0, 4, 7, 5, 2, 6, 1, 3}
    static int[] array = new int[max];
    // 解法数量
    static int count = 0;

    static int judgeCount = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println("解法数量" + count);
        System.out.println("调用多少次" + judgeCount);
    }

    /**
     * 判断当摆放第n个皇后时，是否和前面已经摆放的皇后有冲突
     * @param n
     * @return
     */
    private static boolean judge(int n){
        judgeCount++;
        for (int i = 0; i <n; i++){
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 放置第n个皇后
     * @param n
     */
    private static void check(int n){
        if (n == max){
            print();
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i <max; i++){
            // 先把当前皇后n，放在该行的第一列
            array[n] = i;
            if (judge(n)){
                check(n + 1);
            }
        }
    }

    private static void print(){
        count++;
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + "\t\t");
        }
        System.out.println();
    }
}
