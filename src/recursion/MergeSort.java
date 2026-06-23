package recursion;

public class MergeSort {
    static void main() {
        int[] arr = {3,1,2,4,1,5,2,6,4};
        mergeSort(arr, 0, arr.length-1);
        for(int e : arr){
            System.out.print(e+" ");
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] newArr = new int[arr.length];
        int index = 0;
        int left = l;
        int right = mid+1;
        while(left<= mid && right <= r){
            if(arr[left] <= arr[right]){
                newArr[index++] = arr[left];
                left++;
            }else{
                newArr[index++] = arr[right];
                right++;
            }
        }
        while(left <=mid){
            newArr[index++] = arr[left];
            left++;
        }
        while(right <=r){
            newArr[index++] = arr[right];
            right++;
        }
        for(int i=l;i<=r;i++){
            arr[i] = newArr[i-l];
        }
    }
}
