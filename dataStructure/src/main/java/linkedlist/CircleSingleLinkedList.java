package linkedlist;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月17日 20:11:00
 * @place 公司
 * @copyright 张旭东
 */
public class CircleSingleLinkedList {
    /**
     * 创建first节点
     */
    private Boy first = null;

    /**
     * 添加节点，创建环形链表
     */
    public void add(int num){
        if (num < 1){
            System.out.println("num值不正确");
            return;
        }
        Boy cur = null;     // 辅助指针
        for (int i = 1; i <= num; i++){
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                cur = first;
            }else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    /**
     * 计算节点的出圈顺序
     * @param startNo   表示从第几个节点开始数
     * @param countNo   表示数几下
     * @param num       表示节点数量
     */
    public void countNode(int startNo, int countNo, int num){
        if (first == null || startNo < 1 || startNo > num){
            throw new IllegalArgumentException("参数有误");
        }
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        // 让helper和first指针同时移动（startNo -1）次
        for (int i = 0; i < startNo -1; i++){
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当节点报数时，让helper和first同时移动(countNo -1)次，同时出圈
        while (true){
            if (helper == first){
                break;
            }
            for (int j = 0; j < countNo -1; j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("节点%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后出圈的节点%d",first.getNo());
    }

    /**
     * 输出链表
     */
    public void show(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (true){
            System.out.printf("节点编号%d\n",cur.getNo());
            if (cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }
    }
}
