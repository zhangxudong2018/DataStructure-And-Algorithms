package sort;

import java.util.Arrays;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 选择排序
 * @date 2020年04月05日 16:37:00
 * @place 公司
 * @copyright 张旭东
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("排序前：" + Arrays.toString(array) + "\n");
        long start = System.currentTimeMillis();
        int[] sortArray = sort(array);
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

    public static int[] sort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++){
                if (min > array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
        return array;
    }
}
