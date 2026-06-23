package recursion;

public class QuickSort {
    static void main() {
        int[] arr = {4,6,2,5,7,9,1,3};
        quickSort(arr, 0, arr.length-1);
        for(int e: arr){
            System.out.print(e+" ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex);
            quickSort(arr, partitionIndex+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i<=j){
            while(arr[i] <= pivot && i<=high){
                i++;
            }
            while(arr[j] > pivot && j>=low){
                j--;
            }
            if(i<j){
                swap(arr,i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
