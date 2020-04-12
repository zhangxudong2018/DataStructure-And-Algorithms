package sort;

import java.util.Arrays;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年04月07日 15:03:00
 * @place 公司
 * @copyright 张旭东
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("排序前：" + Arrays.toString(array) + "\n");
        long start = System.currentTimeMillis();
        int[] sortArray = sort(array,0,array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("排序后：" + Arrays.toString(sortArray));
        System.out.println("所需时间：" + (end - start));
    }

    public static int[] createArray(){
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++){
            array[i] = (int)(Math.random() * 100000);
        }
        return array;
    }

    public static int[] sort(int[] array, int left, int right){
        int l = left;
        int r = right;
        // 中值
        int pivot = array[(left + right) / 2];
        int temp = 0;
        // 比pivot值大放在右边
        while (l < r){
            // 在pivot左边一直找，一直找到比pivot值大才退出
            while (array[l] < pivot){
                l += 1;
            }
            // 在pivot右边一直找，一直找到比pivot值小才退出
            while (array[r] > pivot){
                r -= 1;
            }
            if (l >= r){
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            // 如果交换完后，发现array[l] ==  pivot r--，前移
            if (array[l] == pivot){
                r -= 1;
            }
            // 如果交换完后，发现array[r] ==  pivot l++，后移
            if (array[r] == pivot){
                l += 1;
            }
        }
        // 如果l == r,必须l++, r--，否则栈溢出
        if (l == r){
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r){
            sort(array,left,r);
        }
        // 向右递归
        if (right > l){
            sort(array,l,right);
        }
        return array;
    }
}
