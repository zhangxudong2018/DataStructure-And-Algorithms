package search;

import sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 二分查找法思路：前提：有序数组
 *              1.首先确定数组中间下标 mid = (left + right) / 2
 *              2.然后要查找的数findVal与array[mid]比较
 *                  2.1.若findVal > array[mid]，说明findVal在mid右边，需要递归向右查找
 *                  2.2.若findVal < array[mid]，说明findVal在mid左边，需要递归向左查找
 *                  2.3.若findVal = array[mid]，说明找到，则退出
 *              3.结束递归条件
 *                  3.1.找到则结束递归
 *                  3.2.若递归完数组，仍没有找到，也需要结束递归，若left > right结束递归
 * @date 2020年04月12日 21:37:00
 * @place 公司
 * @copyright 张旭东
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = QuickSort.createArray();
        int[] array = QuickSort.sort(arr,0, arr.length -1);
        System.out.println("原数组：" + Arrays.toString(array));
        long start = System.currentTimeMillis();
        int index = search(array, 0, array.length - 1, 32);
        long end = System.currentTimeMillis();
        System.out.println("找到的索引下标：" + index + "\t所需时间：" + (end - start));
        long start1 = System.currentTimeMillis();
        List<Integer> indexList = search2(array, 0, array.length - 1, 32);
        long end1 = System.currentTimeMillis();
        System.out.println("找到的所有元素下标：" + indexList + "\t所需时间：" + (end - start));
    }

    /**
     * 查询，找到返回下标
     * @param array 有序数组
     * @param left 左索引
     * @param right 右索引
     * @param findVal 要查找的元素
     * @return
     */
    public static int search(int[] array, int left, int right, int findVal){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = array[mid];
        if (findVal > midVal){
            return search(array,mid + 1, right, findVal);
        }else if (findVal < midVal){
            return search(array,left, mid - 1, findVal);
        }else {
            return mid;
        }
    }

    public static List<Integer> search2(int[] array, int left, int right, int findVal){
        if (left > right){
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = array[mid];
        if (findVal > midVal){
            return search2(array,mid + 1, right, findVal);
        }else if (findVal < midVal){
            return search2(array,left, mid - 1, findVal);
        }else {
            // 在找到mid值之后，不要马上返回，向mid值左右两边扫描，将所有满足查找值加入到list中
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (temp < 0 || array[temp] != findVal){
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while (true){
                if (temp < 0 || array[temp] != findVal){
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }
}
