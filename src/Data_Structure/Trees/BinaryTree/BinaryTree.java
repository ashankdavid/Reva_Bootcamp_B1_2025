package Data_Structure.Trees.BinaryTree;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node createNode(int val){
        return new Node(val);
    }

    void preDfs(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preDfs(root.left);
        preDfs(root.right);
    }
}

class DriverCode{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = bt.createNode(1);

        root.left = bt.createNode(2); // Level 2
        root.right = bt.createNode(3);

        root.left.left = bt.createNode(4); // level 3
        root.left.right = bt.createNode(5);
        root.right.left = bt.createNode(6);
        root.right.right = bt.createNode(7);

        root.left.right.left = bt.createNode(8); // level 4
        root.right.left.left = bt.createNode(15);
        root.right.left.right = bt.createNode(9);

        bt.preDfs(root);
    }
}