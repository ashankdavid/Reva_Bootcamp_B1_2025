package Programs.LinkedList.RemoveDuplicates;

import java.util.HashSet;

class Node {
    int data;
    Node next;

    // Constructor
    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // Constructor to initialize an empty list
    public LinkedList() {
        head = null;
    }

    // Function to insert a node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Function to display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void removeDuplicates() {
        if(head==null) return;

        HashSet<Integer> HSet = new HashSet<>();
        Node current = head;
        Node prev = null;

        while(current!=null){
            if(HSet.contains(current.data)){
                prev.next = current.next;
            }else{
                HSet.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }
}

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 7, 2, 7, 3, 8, 3, 8};

        LinkedList myList = new LinkedList();

        // Insert elements
        for (int value : arr) {
            myList.insert(value);
        }

        System.out.print("Linked List Before Removing Duplicates: ");
        myList.display();

        myList.removeDuplicates();

        System.out.print("Linked List After Removing Duplicates: ");
        myList.display();
    }
}

