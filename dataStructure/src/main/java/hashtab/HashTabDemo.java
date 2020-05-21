package hashtab;

import java.util.Scanner;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年04月23日 13:19:00
 * @place 公司
 * @copyright 张旭东
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add：添加");
            System.out.println("list：查看");
            System.out.println("find：查找");
            System.out.println("exit：推出");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id：");
                    int id = scanner.nextInt();
                    System.out.println("输入名字：");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id：");
                    int fid = scanner.nextInt();
                    hashTab.findEmpById(fid);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
