package search;

import java.util.Arrays;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 斐波那契查找算法
 * @date 2020年04月23日 12:51:00
 * @place 公司
 * @copyright 张旭东
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] array = {1, 8, 10, 89, 1000, 1234};
        System.out.println("查找数的下标：" + search(array,1000));
    }

    /**
     * 非递归方式得到斐波那契数列
     * @return
     */
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int search(int[] array, int key){
        int low = 0;
        int high = array.length - 1;
        // 表示斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int[] f = fib();
        while (high > f[k] - 1){
            k++;
        }
        // 因为f[k]值肯大于array的长度，因此构建新数组，指向array[]
        int[] temp = Arrays.copyOf(array,f[k]);
        for (int i = high + 1; i < temp.length; i++){
            temp[i] = array[high];
        }
        while (low <= high){
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]){
                high = mid - 1;
                k--;
            }else if(key > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
