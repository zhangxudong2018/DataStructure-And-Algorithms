package search;

import java.util.Arrays;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年04月07日 21:28:00
 * @place 公司
 * @copyright 张旭东
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] array = createArray();
        System.out.println("原数组：" + Arrays.toString(array) + "\n");
        long start = System.currentTimeMillis();
        int index = search(array,432);
        long end = System.currentTimeMillis();
        System.out.println("查找元素下标：" + index);
        System.out.println("所需时间：" + (end - start));
    }

    public static int[] createArray(){
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++){
            array[i] = (int)(Math.random() * 100000);
        }
        return array;
    }

    public static int search(int[] array, int value){
        for (int i = 0; i < array.length; i++){
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }
}
