package Data_Structure.Trees.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

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

public class BST {
    private Node root;

    BST(){
        root = null;
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

    private boolean searchRec(Node root, int key){
        if(root==null){
            return false;
        }
        if(key==root.key){
            return true;
        }if(key < root.key){
            return searchRec(root.left, key);
        }else{
            return searchRec(root.right, key);
        }
    }

    public boolean search(int key){
        return searchRec(root, key);
    }

    private Node findSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    private Node deleteRec(Node root, int key){
        if(root==null){
            return root;
        }
        if(key < root.key){
            root.left = deleteRec(root.left, key);
        }else if(key > root.key){
            root.right = deleteRec(root.right, key);
        }else{
            // Now you found the node to be deleted
            // Case 1: when the node has 0 or 1 child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            // Case 2: When the node has 2 children
            Node successor = findSuccessor(root.right);
            root.key = successor.key;
            root.right = deleteRec(root.right, successor.key);
        }
        return root;
    }

    public void remove(int key){
        root = deleteRec(root, key);
    }

    void BFS(){
        if(root==null){return;}
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.key + " ");
            if(temp.left!=null){
                q.offer(temp.left);
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }
        }
    }
}

class DriverCode{
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(100);
        bst.insert(50);
        bst.insert(150);
        bst.insert(30);
        bst.insert(60);
        bst.insert(130);
        bst.insert(160);
        bst.insert(55);
        bst.BFS();
        int key = 30;
        System.out.println(bst.search(key));
    }
}
