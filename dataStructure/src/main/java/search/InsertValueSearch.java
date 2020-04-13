package search;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 插值查找算法：对于连续有序数组查找有奇效
 * @date 2020年04月13日 15:28:00
 * @place 公司
 * @copyright 张旭东
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] array = createArray();
        int index = search(array, 0, array.length - 1, 12);
        System.out.println("找到的下标：" + index);
    }

    public static int[] createArray(){
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }
        return array;
    }

    public static int search(int[] array, int left, int right, int findVal){
        if (left > right || findVal < array[0] || findVal > array[array.length - 1]){
            return -1;
        }
        int mid = left + (right - left) * (findVal - array[left]) / (array[right] - array[left]);
        int midVal = array[mid];
        if (findVal > midVal){
            return search(array,mid + 1, right, findVal);
        }else if (findVal < midVal){
            return search(array, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
