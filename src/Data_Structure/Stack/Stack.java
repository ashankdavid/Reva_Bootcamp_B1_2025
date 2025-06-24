package Data_Structure.Stack;

public class Stack {
    int[] arr;
    int top;
    int size;

    Stack(int size){
        this.size = size;
        top = -1;
        arr = new int[size];
    }

    void push(int val){
        if(top == size-1){
            System.out.println("Stack Overflown");
            return;
        }
        top++;
        arr[top] = val;
    }

    void pop(){
        if(top==-1){
            System.out.println("No element to Pop");
            return;
        }
        top--;
    }

    int Top(){
        if(top==-1){
            System.out.println("No element to Pop");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty(){
        return top == -1;
    }
}

class Drivercode{
    public static void main(String[] args) {
        Stack st = new Stack(10);
    }
}
