package recursive;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function    用递归算法实现迷宫
 * @date 2019年12月18日 19:52:00
 * @place 公司
 * @copyright 张旭东
 */
public class Maze {
    public static void main(String[] args) {
        int[][] maze = buildMaze();
        System.out.println("============================原始地图=====================");
        show(maze);
        setWay(maze,1, 1);
        System.out.println("============================小球路径=====================");
        show(maze);
    }

    /**
     * 构建迷宫
     * @return
     */
    public static int[][] buildMaze(){
        int[][] maze = new int[8][7];
        for (int i = 0; i < maze.length; i++){
            maze[i][0] = 1;
            maze[i][maze[0].length - 1] = 1;
        }
        for (int i = 0; i < maze[0].length; i++){
            maze[0][i] = 1;
            maze[maze.length - 1][i] = 1;
        }
        // 设置挡板
        maze[3][1] = 1;
        maze[3][2] = 1;
//        maze[1][2] = 1;
//        maze[2][2] = 1;
        return maze;
    }

    /**
     * 输出迷宫
     * @param maze
     */
    public static void show(int[][] maze){
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                System.out.printf(maze[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    /**
     * 递归实现路径
     * 小球从map[1][1]开始走到map[6][5]走通
     * 约定：1表示墙不能走，2表示可以走，3表示已走过，不能走
     * 约定一个策略：上->右->下->左，如果不行再回溯
     * @param map 地图
     * @param i 从哪个位置开始
     * @param j
     * @return  能否走通
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[map.length - 2][map[0].length - 2] == 2){
            return true;
        }else {
            // 表示当前点没有走过
            if (map[i][j] == 0){
                //  按照策略走
                map[i][j] = 2;
                if (setWay(map,i + 1,j)){
                    // 向下走
                    return true;
                }else if(setWay(map, i, j + 1)){
                    // 向右走
                    return true;
                }else if(setWay(map, i - 1, j)){
                    // 向上走
                    return true;
                }else if(setWay(map, i, j - 1)){
                    // 向左走
                    return true;
                }else {
                    // 走不通
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
