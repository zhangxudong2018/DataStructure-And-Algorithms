package sort;

import java.util.Arrays;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年04月05日 17:45:00
 * @place 公司
 * @copyright 张旭东
 */
public class ShellSort {
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
        int temp = 0;
        for (int gap = array.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < array.length; i++){
                for (int j = i - gap; j >= 0; j -= gap){
                    if (array[j] > array[j + gap]){
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
        return array;
    }
}
