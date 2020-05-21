package tree;

/**
 * @author 张旭东
 * @version 1.0.0
 * @function
 * @date 2020年05月17日 14:53:00
 * @place 公司
 * @copyright 张旭东
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode hero1 = new HeroNode(2, "吴用");
        HeroNode hero2 = new HeroNode(3, "吴俊义");
        HeroNode hero3 = new HeroNode(4,"林冲");
        // 创建二叉树
        binaryTree.setRoot(root);
        root.setLeft(hero1);
        root.setRight(hero2);
        hero2.setRight(hero3);
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("\n中序遍历");
        binaryTree.infixOrder();
        System.out.println("\n后序遍历");
        binaryTree.postOrder();
    }
}
