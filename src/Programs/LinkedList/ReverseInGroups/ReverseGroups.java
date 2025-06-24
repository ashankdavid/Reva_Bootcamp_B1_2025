package Programs.LinkedList.ReverseInGroups;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {
    Node head;

    SLL() {
        head = null;
    }

    public void insertAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private Node reverseInGroups(Node head, int k) {
        if(head == null || k == 1){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;

        while(curr!=null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next!=null){
            head.next = reverseInGroups(next, k);
        }
        return prev;

    }


    public void reverseGroups(int k) {
        head = reverseInGroups(head, k);
    }

    public static void main(String[] args) {
        SLL obj = new SLL();
        obj.insertAtHead(10);
        obj.insertAtHead(9);
        obj.insertAtHead(8);
        obj.insertAtHead(7);
        obj.insertAtHead(6);
        obj.insertAtHead(5);
        obj.insertAtHead(4);
        obj.insertAtHead(3);
        obj.insertAtHead(2);
        obj.insertAtHead(1);

        System.out.print("Original List: ");
        obj.display();

        int k = 3;
        obj.reverseGroups(k);

        System.out.print("Reversed List in Groups of " + k + ": ");
        obj.display();
    }
}
