package Programs.Arrays;

public class MinimumSumSubarray {
    static int MinSumArray(int[] arr){
        int minimum = arr[0];
        int currMinimum = arr[0];

        for(int i=1; i<arr.length; i++){
            currMinimum = Math.min(arr[i] , currMinimum+arr[i]);
            minimum = Math.min(minimum, currMinimum);
        }

        return minimum;
    }

    public static void main(String[] args) {
        int[] arr = {3,-4,2,-3,-1,7,-5};
        System.out.println("MinSum: " + MinSumArray(arr));
    }
}


