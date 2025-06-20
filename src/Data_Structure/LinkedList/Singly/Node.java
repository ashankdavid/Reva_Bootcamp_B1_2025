package Data_Structure.LinkedList.Singly;

public class Node {
    int data;
    Node next;

    Node(int data){
       this.data = data;
       this.next = null;
    }
}

class SLL{
    Node head;

    SLL(){
        head = null;
    }

    void insertAtHead(int val){
        Node n = new Node(val);
        n.next = head;
        head = n;
    }

    void insertAtTail(int val){
        Node n = new Node(val);
        if(head==null){
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = n;
    }

    int getSize(){
        int size = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    void insertAtPos(int val, int pos){
        Node n = new Node(val);
        int size = getSize();
        if(pos<0 || pos>size){
            System.out.println("Invalid Position given!");
        }else if(pos==0){
            insertAtHead(val);
        }else{
            Node temp = head;
            while(--pos > 0){
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }

    }

    void deleteAtHead(){
        if(head==null){
            System.out.println("Linked List is Empty!");
            return;
        }
        Node todelete = head;
        head = head.next;
        todelete = null; //<------Garbage Collection will be called
    }

    void deleteByVal(int val){
        if(head==null) return;

        if(head.data == val){
            deleteAtHead();
            return;
        }

        Node temp = head;
        while(temp.next!=null && temp.next.data != val){
            temp = temp.next;
        }

        if(temp.next == null){
            System.out.println("Value was not found");
            return;
        }

        Node todelete = temp.next;
        temp.next = temp.next.next;
        todelete = null;
    }

    void displayLL(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

class DriverCode{
    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.deleteAtHead();
        sll.insertAtTail(100);
        sll.displayLL();
        sll.insertAtHead(10);
        sll.insertAtHead(20);
        sll.insertAtHead(30);
        sll.insertAtHead(40);
        sll.insertAtHead(50);
        sll.displayLL();
        sll.insertAtPos(500, 200);
        sll.displayLL();
        sll.deleteAtHead();
        sll.displayLL();
        sll.deleteByVal(400);
        sll.displayLL();
    }
}