package linkedlist;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2019年12月16日 19:10:00
 * @place 公司
 * @copyright 张旭东
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleHeroNode hero1 = new SingleHeroNode(1,"宋江","及时雨");
        SingleHeroNode hero2 = new SingleHeroNode(2,"晁盖","托塔天王");
        SingleHeroNode hero3 = new SingleHeroNode(3,"卢俊义","玉麒麟");
        SingleHeroNode hero4 = new SingleHeroNode(4,"林冲","豹子头");
        SingleHeroNode hero5 = new SingleHeroNode(5,"李逵","黑旋风");

        SingleLinkedList linkedList = new SingleLinkedList();
//        System.out.println("===============不考虑顺序添加节点===============");
//        linkedList.add(hero1);
//        linkedList.add(hero2);
//        linkedList.add(hero3);
//        linkedList.add(hero4);
//        linkedList.add(hero5);
//        linkedList.list();

//        System.out.println("=====================按顺序添加节点======================");
        linkedList.addByOrder(hero5);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero1);
        System.out.println("===========================修改前=====================");
        linkedList.list();
        SingleHeroNode updateHero = new SingleHeroNode(5,"李逵逵","~~~黑旋风~~~");
        linkedList.update(updateHero);
        System.out.println("===========================修改后=====================");
        linkedList.list();
        System.out.println("===========================删除后=====================");
        linkedList.delete(5);
//        linkedList.delete(4);
//        linkedList.delete(3);
//        linkedList.delete(2);
//        linkedList.delete(1);
        linkedList.list();

        System.out.println("单链表的节点个数" + linkedList.getLength(linkedList.getHead()));

        System.out.println("倒数第1个节点" + linkedList.findLastIndexNode(linkedList.getHead(),1));

        System.out.println("===========================链表反转后======================");
        linkedList.reverseList(linkedList.getHead());
        linkedList.list();
        System.out.println("===========================逆序打印========================");
        linkedList.reversePrint(linkedList.getHead());
    }
}
