package hashtab;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 管理多条链表
 * @date 2020年04月23日 13:39:00
 * @place 公司
 * @copyright 张旭东
 */
public class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    /**
     * 表示链表的数量
     */
    private int size;

    public HashTab(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        // 根据员工id得到该添加到哪条链表
        int empLinkedListNo = hashFun(emp.getId());
        // 将emp添加到对应链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++){
            empLinkedListArray[i].list();
        }
    }

    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null){
            System.out.println("找到");
        }else{
            System.out.println("没有找到");
        }
    }

    /**
     * 散列函数
     * @param id
     * @return
     */
    public int hashFun(int id){
        return id % size;
    }
}
