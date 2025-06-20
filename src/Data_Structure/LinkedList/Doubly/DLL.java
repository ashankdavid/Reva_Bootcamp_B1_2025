package Data_Structure.LinkedList.Doubly;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DLL {
    Node head;

    DLL() {
        head = null;
    }

    void insertAtHead(int val) {
        Node n = new Node(val);
        if (head != null) {
            n.next = head;
            head.prev = n;
        }
        head = n;
    }

    void insertAtTail(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    int getSize() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    void insertAtPos(int val, int pos) {
        int size = getSize();
        if (pos < 0 || pos > size) {
            System.out.println("INVALID POSITION");
        } else if (pos == 0) {
            insertAtHead(val);
        } else {
            Node n = new Node(val);
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            n.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = n;
            }
            n.prev = temp;
            temp.next = n;
        }
    }

    void deleteAtHead() {
        if (head == null) return;

        Node temp = head;
        head = head.next;

        if (head != null) {
            head.prev = null;
        }

        temp = null;
    }

    void deleteByVal(int val) {
        if (head == null) return;

        if (head.data == val) {
            deleteAtHead();
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != val) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value " + val + " Not Found!");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        temp = null;
    }

    void displayLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DLL obj = new DLL();
        obj.insertAtHead(10);
        obj.insertAtHead(20);
        obj.insertAtHead(30);
        obj.insertAtHead(100);
        obj.displayLL();

        obj.insertAtTail(1000);
        obj.displayLL();

        obj.insertAtPos(300, 1000); // Invalid
        obj.displayLL();

        obj.deleteAtHead();
        obj.displayLL();

        obj.deleteByVal(300);
        obj.displayLL();
    }
}

