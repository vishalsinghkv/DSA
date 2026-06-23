package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintOneSubSequenceWithSumK {
    static void main() {
        int[] arr = {1,2,1};
        int k = 2;
        printSubSequenceWithSumK(arr, 0,0, k, new ArrayList<>());
    }

    private static boolean printSubSequenceWithSumK(int[] arr, int index, int sum, int target, List<Integer> ans) {
        if(index == arr.length){
            if(sum == target){
                System.out.println(ans);
                return true;
            }
            return false;
        }
        sum = sum+arr[index];
        ans.add(arr[index]);
        if(printSubSequenceWithSumK(arr, index+1, sum, target, ans)){
            return true;
        }
        sum = sum - arr[index];
        ans.removeLast();
        if(printSubSequenceWithSumK(arr, index+1, sum, target, ans)){
            return true;
        }
        return false;
    }
}
