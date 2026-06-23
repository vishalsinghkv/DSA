package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    static void main() {
        int[] arr = {2,3};
        List<Integer> res = new ArrayList<>();
        findSubSetSum(arr, 0, 0, res);
        Collections.sort(res);
        System.out.println(res);
    }

    private static void findSubSetSum(int[] arr, int index, int sum, List<Integer> res) {
        if(index == arr.length){
            res.add(sum);
            return;
        }
        findSubSetSum(arr, index+1, sum+arr[index], res);
        findSubSetSum(arr, index+1, sum, res);
    }
}
