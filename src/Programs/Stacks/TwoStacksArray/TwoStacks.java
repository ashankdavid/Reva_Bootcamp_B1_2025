package Programs.Stacks.TwoStacksArray;

public class TwoStacks {
    int[] arr;
    int size;
    int top1, top2;

    TwoStacks(int n){
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = n;
    }

    void push1(int x){
        if(top1 + 1 < top2){
            arr[++top1] = x;
        }else{
            System.out.println("Stack1 Overflown");
        }
    }

    void push2(int x){
        if(top2-1 > top1){
            arr[--top2] = x;
        }else{
            System.out.println("Stack2 Overflown");
        }
    }

    int pop1(){
        if(top1>=0){
            return arr[top1--];
        }else{
            System.out.println("Stack1 Underflown");
            return -1;
        }
    }

    int pop2(){
        if(top2 < size){
            return arr[top2++];
        }else{
            System.out.println("Stack2 Underflown");
            return -1;
        }
    }

}
