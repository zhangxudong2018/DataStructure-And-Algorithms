package sort;

import java.util.Arrays;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年04月07日 18:18:00
 * @place 公司
 * @copyright 张旭东
 */
public class RadixSort {
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
        // 1.得到数组中最大数的位数
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        // 得到最大数是几位数
        int maxLength = (max + "").length();
        // 定义一个二维数组，表示10个桶，每个桶都是一个一维数组
        int[][] bucket = new int[10][array.length];
        // 为了记录每个桶中实际的数目，定义一个一维数组表示
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10){
            // 针对位数进行排序
            for (int j = 0; j < array.length; j++){
                // 取出每个元素个位的值
                int digitOfElement = array[j] / n % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照桶的顺序，遍历每一个桶，并将数据放入原数组
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++){
                // 如果桶中有数据才放入桶中
                if (bucketElementCounts[k] != 0){
                    for (int l = 0; l < bucketElementCounts[k]; l++){
                        array[index++] = bucket[k][l];
                    }
                }
                // 第i + 1轮后,需将bucketElementCounts[k] = 0 !!!!!
                bucketElementCounts[k] = 0;
            }
        }
        return array;
    }
}
