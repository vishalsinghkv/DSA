package recursion;

public class CountSubSequenceWithSumK {
    static void main() {
        int[] arr = {1,2,1};
        int k = 2;
        int count = printSubSequenceWithSumK(arr, 0,0, k);
        System.out.println(count);
    }

    private static int printSubSequenceWithSumK(int[] arr, int index, int sum, int target) {
        if(index == arr.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        sum = sum+arr[index];
        int l = printSubSequenceWithSumK(arr, index+1, sum, target);
        sum = sum - arr[index];
        int r  = printSubSequenceWithSumK(arr, index+1, sum, target);
        return l+r;
    }
}
