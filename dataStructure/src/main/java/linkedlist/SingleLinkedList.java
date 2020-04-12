package linkedlist;

import java.util.Stack;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月16日 19:16:00
 * @place 公司
 * @copyright 张旭东
 */
public class SingleLinkedList {

    /**
     * 初始化头节点
     */
    private SingleHeroNode head = new SingleHeroNode(0,"","");

    public SingleHeroNode getHead() {
        return head;
    }

    /**
     * 添加节点
     *      思路：当不考虑编号顺序时
     *          （1）找到当前链表的最后节点
     *          （2）当最后节点的next指向新的节点
     * @param heroNode
     */
    public void add(SingleHeroNode heroNode){
        // 指定一个辅助节点
        SingleHeroNode temp = head;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
        }
        // 当循环退出，表示temp指向链表的最后
        temp.setNext(heroNode);
    }

    /**
     * 根据编号按顺序添加
     * @param heroNode
     */
    public void addByOrder(SingleHeroNode heroNode){
        // 因为是单链表，temp指向添加位置的前一个节点
        SingleHeroNode temp = head;
        boolean flag = false;   // 表示添加的节点编号是否存在
        while (true){
            // temp已经是链表最后
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() > heroNode.getNo()){
                // 位置找到，就在此插入
                break;
            }
            if (temp.getNext().getNo() == heroNode.getNo()){
                // 节点编号已存在
                flag = true;
                break;
            }
            // 指针后移
            temp = temp.getNext();
        }
        if (flag){
            System.out.println("节点已存在,不能添加" + temp.getNo());
        } else {
            // heroNode的next指向temp的next
            heroNode.setNext(temp.getNext());
            // temp的next指向heroNode
            temp.setNext(heroNode);
        }
    }

    /**
     * 根据编号修改节点
     * @param heroNode
     */
    public void update(SingleHeroNode heroNode){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        SingleHeroNode temp = head.getNext();
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() == heroNode.getNo()){
                // 找到
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag){
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        }else {
            System.out.println("没有此节点");
        }
    }

    /**
     * 根据编号删除节点
     * @param no
     */
    public void delete(int no){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        SingleHeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() == no){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("没有此数据");
        }
    }

    /**
     * 单链表面试题：求单链表有效节点的个数（不包括头节点）
     * @param head
     * @return
     */
    public int getLength(SingleHeroNode head){
        if (head.getNext() == null){
            return 0;
        }
        SingleHeroNode cur = head.getNext();
        int length = 0;
        while (cur != null){
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    /**
     * 新浪面试题：查找单链表中倒数第k个节点
     *      思路： 从头到尾遍历，得到链表长度size，和倒数第index个节点
     *              在从头遍历(size-index)个节点
     * @param index
     * @param head
     * @return
     */
    public SingleHeroNode findLastIndexNode(SingleHeroNode head, int index){
        if (head.getNext() == null){
            return null;
        }
        int size = getLength(head);
        if (index < 0 || index > size){
            return null;
        }
        SingleHeroNode cur = head.getNext();
        for (int i = 0; i < size - index; i++){
            cur = cur.getNext();
        }
        return cur;
    }

    /**
     * 腾讯面试题：单链表的反转
     *              思路：从头遍历原链表，并依次取出，并放在新链表的最前端
     * @param head
     */
    public void reverseList(SingleHeroNode head){
        if (head.getNext() == null || head.getNext().getNext() == null){
            return;
        }
        SingleHeroNode cur = head.getNext();
        SingleHeroNode next = null;           // 当前节点的下一个节点
        SingleHeroNode reverseHead = new SingleHeroNode(0,"","");
        while (cur != null){
            next = cur.getNext();
            cur.setNext(reverseHead.getNext());
            reverseHead.setNext(cur);
            cur = next;
        }
        // 将head的next指向reverseHead的next
        head.setNext(reverseHead.getNext());
    }

    /**
     * 百度面试题：逆序打印单链表
     *              思路：使用栈结构，先进后出的特点逆序打印
     * @param head
     */
    public void reversePrint(SingleHeroNode head){
        if (head.getNext() == null){
            return;
        }
        Stack<SingleHeroNode> stack = new Stack();
        SingleHeroNode cur = head.getNext();
        // 将链表的所有节点压入栈中
        while (cur != null){
            stack.push(cur);
            cur = cur.getNext();
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序链表，合并之后仍然有序
     */
    public void mergeLinkedList(SingleHeroNode head1, SingleHeroNode head2){
        if (head1.getNext() == null || head2.getNext() == null){
            return;
        }
        SingleHeroNode cur1 = head1.getNext();
        SingleHeroNode cur2 = head2.getNext();
        SingleHeroNode next1 = null;
        SingleHeroNode next2 = null;
        SingleHeroNode newHead = new SingleHeroNode(0,"","");
        while (cur1 != null){
            next1 = cur1.getNext();
            if (cur1.getNo() < cur2.getNo()){
                head1.setNext(next1);
                cur1.setNext(newHead.getNext());
                newHead.setNext(cur1);
                cur2 = cur2.getNext();
            }
        }
    }

    /**
     * 输出链表
     */
    public void list(){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能东，所以需要辅助变量来遍历
        SingleHeroNode temp = head.getNext();
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            // temp后移
            temp = temp.getNext();
        }
    }
}
