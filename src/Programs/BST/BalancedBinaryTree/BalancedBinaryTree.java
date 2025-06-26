package Programs.BST.BalancedBinaryTree;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BalancedBinaryTree {
    static int height(Node root){
        if(root==null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static boolean isBalanced(Node root){
        if(root==null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <=1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);
        root.right.right.right.right = new Node(5);
        root.left = new Node(6);

        if(isBalanced(root)){
            System.out.println("Yessssss");
        }else{
            System.out.println("Noooo");
        }

    }
}
