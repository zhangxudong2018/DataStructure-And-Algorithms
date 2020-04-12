package linkedlist;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月17日 20:04:00
 * @place 公司
 * @copyright 张旭东
 */
public class Boy {
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
