package linkedlist;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function 单链表
 * @date 2019年12月16日 19:11:00
 * @place 公司
 * @copyright 张旭东
 */
public class SingleHeroNode {
    /**
     * 编号
     */
    private int no;
    /**
     * 名称
     */
    private String name;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 指向下一个节点
     */
    private SingleHeroNode next;

    public SingleHeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public SingleHeroNode getNext() {
        return next;
    }

    public void setNext(SingleHeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
