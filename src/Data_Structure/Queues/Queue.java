package Data_Structure.Queues;

public class Queue {
    int [] arr;
    int front;
    int back;
    final int size = 20;

    Queue(){
        arr = new int[size];
        front = -1;
        back = -1;
    }

    void push(int x){
        if(back == size-1){
            System.out.println("Overflown");
            return ;
        }

        back++;
        arr[back] = x;
        if(front == -1){
            front++;
        }
    }

    void pop(){
        if(front == -1 || front > back){
            System.out.println("Underflown");
            return;
        }
        front++;
    }

    int peek(){
        if(front == -1 || front > back){
            System.out.println("Underflown");
            return -1;
        }
        return arr[front];
    }

    boolean isEmpty(){
        return (front==-1 || front > back);
    }
}
