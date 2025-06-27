package Data_Structure.Heaps;

public class MaxHeap {
    int[] arr;
    int maxSize; // Max size of heap
    int heapSize; // Current no of elements in heap

    MaxHeap(int maxSize){
        this.maxSize = maxSize;
        this.heapSize =0;
        this.arr = new int[maxSize];
    }

    int parent(int i) { return (i-1) / 2;}
    int leftChild(int i) {return  2*i-1;}
    int rightChild(int i) { return 2*i+2;}



    void heapify(int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if(left < heapSize && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < heapSize && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            swap(i, largest);
            heapify(largest);
        }
    }

    void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void insert(int key){
        if(heapSize == maxSize){
            System.out.println("Overflow");
            return;
        }
        heapSize++;
        int i = heapSize -1;
        arr[i] = key;

        // heapify up
        while(i>0 && arr[parent(i)] < arr[i]){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    int extractMax(){
        if(heapSize <= 0){
            return -1;
        }
        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;

        heapify(0);
        return root;

    }

    void increaseKey(int i, int newValue){
        arr[i] = newValue;

        while(i>0 && arr[parent(i)] < arr[i]){
            swap(i, parent(i));
            i = parent(i);
        }

    }

    void deleteKey(int i){
        increaseKey(i, Integer.MAX_VALUE);
        extractMax();
    }
}
class DriverCode{
    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(15);

        int[] keys = {100, 40,50,60,70,80,90};
        for(int key : keys){
            h.insert(key);
        }


    }
}
