package sort;

import java.util.Arrays;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 归并排序
 * @date 2020年04月07日 15:46:00
 * @place 公司
 * @copyright 张旭东
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("排序前：" + Arrays.toString(array) + "\n");
        int[] temp = new int[array.length];
        long start = System.currentTimeMillis();
        int[] sortArray = sort(array, 0, array.length - 1, temp);
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

    public static int[] sort(int[] array, int left, int right, int[] tempArr){
        if (left < right){
            int mid = (left + right) / 2;
            sort(array, left, mid, tempArr);
            sort(array,mid + 1,right, tempArr);
            merget(array, left, mid, right, tempArr);
        }
        return array;
    }

    /**
     * 合并的方法
     * @param array 原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param tempArr 作中转的数组
     * @return
     */
    public static void merget(int[] array, int left, int mid, int right, int[] tempArr){
        // 左边有序序列的初始索引
        int i = left;
        // 左边有序序列的初始索引
        int j = mid + 1;
        // tempArr数组当前索引
        int t = 0;
        // 先把左右两边有序序列按照规则添加到tempArr
        // 直到一边的有序序列处理完为止
        while (i <= mid && j <= right){
            if (array[i] <= array[j]){
                tempArr[t] = array[i];
                t += 1;
                i += 1;
            }else {
                tempArr[t] = array[j];
                t += 1;
                j += 1;
            }
        }
        // 将两边有序数列剩余序列添加到tempArr
        while (i <= mid){
            tempArr[t] = array[i];
            t += 1;
            i += 1;
        }
        while (j <= right){
            tempArr[t] = array[j];
            t += 1;
            j += 1;
        }

        // 将tempArr数组拷贝到array
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            array[tempLeft] = tempArr[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
