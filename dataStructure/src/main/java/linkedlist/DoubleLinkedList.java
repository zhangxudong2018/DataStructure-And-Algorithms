package linkedlist;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function    双向链表
 * @date 2019年12月17日 19:07:00
 * @place 公司
 * @copyright 张旭东
 */
public class DoubleLinkedList {

    /**
     * 初始化头节点
     */
    private DoubleHeroNode head = new DoubleHeroNode(0,"","");

    public DoubleHeroNode getHead() {
        return head;
    }

    public void add(DoubleHeroNode heroNode){
        // 指定一个辅助节点
        DoubleHeroNode temp = head;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
        }
        // 当循环退出，表示temp指向链表的最后
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }

    public void update(DoubleHeroNode heroNode){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode temp = head.getNext();
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

    public void delete(int no){
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode temp = head.getNext();
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() == no){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.getPre().setNext(temp.getNext());
            if (temp.getNext() != null){
                temp.getNext().setPre(temp.getPre());
            }
        } else {
            System.out.println("没有此数据");
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
        DoubleHeroNode temp = head.getNext();
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
