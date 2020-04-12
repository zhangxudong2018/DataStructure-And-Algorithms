package array;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月15日 21:03:00
 * @place 公司
 * @copyright 张旭东
 */
public class SparseArray {

    /**
     *  稀疏数组：将原有的二维数组转换为稀疏数组
     *  稀疏数组的存储：
     *          行                   列               值
     *    0    原数组的行数         原数组的列数      原数组有效值的个数
     *    1    原数组第几行         原数组第几列      原数组的值
     *
     *    课后练习：在此基础上，将稀疏数组保存到磁盘如map.data。
     *              在将文件恢复成数组
     */
    public static void main(String[] args) {
        int[][] chessArray = createArray();
        sparseArray(chessArray);

        int[][] sparseArr = createSparseArray();
        transfer(sparseArr);
    }

    /**
     * 创建一个原始的二维数组（棋盘）11 * 11
     * 1表示黑子；2表示白子；0表示没有棋子
     * @return
     */
    public static int[][] createArray(){
        int[][] chessArray = new int[11][15];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[10][11] = -12;
        chessArray[7][8] = 3;
        chessArray[4][4] = -10;
        System.out.println("===================原数组===================");
        print(chessArray);
        return chessArray;
    }

    /**
     * 根据原数组转换成稀疏数组
     * @param array
     * @return
     */
    public static int[][] sparseArray(int[][] array){
        int sum = 0;
        // 遍历原数组
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if (array[i][j] != 0){
                    sum++;
                }
            }
        }
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = array.length;
        sparseArr[0][1] = array[0].length;
        sparseArr[0][2] = sum;

        // 遍历原数组，将非0的数加入到稀疏数组中
        // 用来记录第几个非0的数
        int count = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if (array[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = array[i][j];
                }
            }
        }
        System.out.println("===================转换成稀疏数组后=================");
        print(sparseArr);
        return sparseArr;
    }

    /**
     * 打印
     * @param chessArray
     */
    public static void print(int[][] chessArray){
        for (int[] array : chessArray){
            for (int num : array){
                System.out.printf("%d\t",num);
            }
            System.out.println();
        }
    }

    /**
     * 将稀疏数组转换成原二维数组
     *  思路：根据稀疏数组第一行数据创建二维数组
     *      再根据后几行的数据，填充到二维数组中
     * @param array
     * @return
     */
    public static int[][] transfer(int[][] array){
        int[][] transferArray = new int[array[0][0]][array[0][1]];
        for (int i = 1; i < array.length; i++){
            transferArray[array[i][0]][array[i][1]] = array[i][2];
        }
        System.out.println("=====================将稀疏数组转换后的原数组======================");
        print(transferArray);
        return transferArray;
    }

    /**
     * 创建稀疏数组
     * @return
     */
    public static int[][] createSparseArray(){
        int[][] sparseArray = new int[6][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 15;
        sparseArray[0][2] = 5;
        sparseArray[1][0] = 1;
        sparseArray[1][1] = 2;
        sparseArray[1][2] = 1;
        sparseArray[2][0] = 2;
        sparseArray[2][1] = 3;
        sparseArray[2][2] = 2;
        sparseArray[3][0] = 4;
        sparseArray[3][1] = 4;
        sparseArray[3][2] = -10;
        sparseArray[4][0] = 7;
        sparseArray[4][1] = 8;
        sparseArray[4][2] = 3;
        sparseArray[5][0] = 10;
        sparseArray[5][1] = 11;
        sparseArray[5][2] = -12;
        return sparseArray;
    }

}
