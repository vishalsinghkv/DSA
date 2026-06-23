package recursion;

//Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
//  Note: The solution set must not contain duplicate combinations.
// combination should be in sorted order lexicographically

import java.util.*;

public class CombinationSum2 {
    static void main() {
        int[] arr = {1,2,1,1,2};
        int target = 4;
        List<List<Integer>> ans = new ArrayList<>();
        // sorting so that subarrays will be in sorted order
        Arrays.sort(arr);
        findCombinationSum(arr, target, 0, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void findCombinationSum(int[] arr, int target,int index, List<List<Integer>> ans, List<Integer> subAns) {
        if (target == 0) {
            ans.add(new ArrayList<>(subAns));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i > index && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i] > target){
                break;
            }
            subAns.add(arr[i]);
            findCombinationSum(arr, target - arr[i], i+1, ans, subAns);
            subAns.removeLast();
        }
    }
}
