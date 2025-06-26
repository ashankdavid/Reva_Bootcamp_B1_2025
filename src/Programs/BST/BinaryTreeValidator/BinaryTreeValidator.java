package Programs.BST.BinaryTreeValidator;

class Node{
    int key;
    Node left;
    Node right;

    Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BST {
    private Node root;
    Long prevVal;

    BST(){
        root = null;
        prevVal = null;
    }

    // Helper Function for Insert Main Function
    private Node insertRec(Node root, int key){
        if(root==null){
            return new Node(key);
        }
        if(key < root.key){
            root.left = insertRec(root.left, key);
        }else if(key > root.key){
            root.right = insertRec(root.right, key);
        }return root;
    }

    // Insert Main Function
    public void insert(int key){
        root = insertRec(root, key);
    }

    // METHOD 1 - Traditional Method
    private boolean isBSTHelper(Node node, long min, long max) {
        if (node == null) return true;
        if (node.key <= min || node.key >= max) return false;

        return isBSTHelper(node.left, min, node.key) &&
                isBSTHelper(node.right, node.key, max);
    }

    public boolean isBST() {
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // METHOD 2 - Inorder Traversal Method
    private boolean inorderCheck(Node node){
        if(node == null) return true;
        if(!inorderCheck(node.left)) return false;
        if(prevVal!=null && node.key <= prevVal) return false;
        prevVal = (long) node.key;
        return inorderCheck(node.right);

    }

    public boolean isBSTInorder(){
        prevVal = null;
        return inorderCheck(root);
    }


}

public class BinaryTreeValidator {
    public static void main(String[] args) {
        BST bt = new BST();
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values) {
            bt.insert(val);
        }

        System.out.println("Method 1 (Range Check): Is BST? " + bt.isBST());
        System.out.println("Method 2 (Optimized Inorder DFS): Is BST? " + bt.isBSTInorder());
    }
}

