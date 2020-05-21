package hashtab;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年04月23日 13:25:00
 * @place 公司
 * @copyright 张旭东
 */
public class EmpLinkedList {
    private Emp head;

    /**
     * 添加雇员
     * @param emp
     */
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.getNext() == null){
                break;
            }
            curEmp = curEmp.getNext();
        }
        curEmp.setNext(emp);
    }

    /**
     * 遍历
     */
    public void list(){
        if (head == null){
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表信息位：");
        Emp curEmp = head;
        while (true){
            System.out.printf("id = %d name = %s\t",curEmp.getId(),curEmp.getName());
            if (curEmp.getNext() == null){
                break;
            }
            curEmp = curEmp.getNext();
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.getId() == id){
                break;
            }
            if (curEmp.getNext() == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.getNext();
        }
        return curEmp;
    }
}
