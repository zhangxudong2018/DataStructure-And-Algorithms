package linkedlist;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月17日 20:03:00
 * @place 公司
 * @copyright 张旭东
 */
public class JosepfuTest {

    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.add(20);
        linkedList.show();
        linkedList.countNode(5,5,25);
    }
}
