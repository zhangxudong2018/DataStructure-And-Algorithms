package linkedlist;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月17日 19:32:00
 * @place 公司
 * @copyright 张旭东
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleHeroNode hero1 = new DoubleHeroNode(1,"宋江","及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2,"晁盖","托塔天王");
        DoubleHeroNode hero3 = new DoubleHeroNode(3,"卢俊义","玉麒麟");
        DoubleHeroNode hero4 = new DoubleHeroNode(4,"林冲","豹子头");
        DoubleHeroNode hero5 = new DoubleHeroNode(5,"李逵","黑旋风");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero5);
        System.out.println("=====================原链表====================");
        doubleLinkedList.list();
        DoubleHeroNode hero = new DoubleHeroNode(5,"李逵逵","~~~黑旋风~~~");
        doubleLinkedList.update(hero);
        System.out.println("=====================修改后====================");
        doubleLinkedList.list();
        System.out.println("=====================删除后====================");
        doubleLinkedList.delete(5);
        doubleLinkedList.list();
    }
}
