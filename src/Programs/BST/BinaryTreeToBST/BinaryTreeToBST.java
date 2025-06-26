package Programs.BST.BinaryTreeToBST;

import java.util.*;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeToBST {

    int index = 0;

    void storeInorderVal(Node root, List<Integer> values){
        if(root==null) return;
        storeInorderVal(root.left, values);
        values.add(root.data);
        storeInorderVal(root.right, values);
    }

    void convertToBST(Node root, List<Integer> values){
        if(root==null) return;

        convertToBST(root.left, values);
        root.data = values.get(index++);
        convertToBST(root.right, values);
    }

    void printTree(Node root){
        if(root==null) return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

}
