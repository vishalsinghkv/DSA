package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//The solution set must not contain duplicate subsets. Return the solution in any order.
//Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

public class SubsetSum2 {
    static void main() {
        int[] arr = {1,2,2};
        List<List<Integer>> ans = new ArrayList<>();
        findSubSetSum(arr, 0, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void findSubSetSum(int[] arr, int index, List<List<Integer>> ans, List<Integer> subAns) {
        ans.add(new ArrayList<>(subAns));
        for(int i=index; i< arr.length;i++){
            if(i!=index && arr[i] == arr[i-1]){
                continue;
            }
            subAns.add(arr[i]);
            findSubSetSum(arr, i+1, ans, subAns);
            subAns.removeLast();
        }
    }
}
