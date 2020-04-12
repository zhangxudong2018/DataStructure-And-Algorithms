package sort;

import java.util.Arrays;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年04月05日 17:12:00
 * @place 公司
 * @copyright 张旭东
 */
public class InsertSort {
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
        for (int i = 0; i < array.length; i++){
            int insertValue = array[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < array[insertIndex]){
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex + 1] = insertValue;
        }
        return array;
    }
}
