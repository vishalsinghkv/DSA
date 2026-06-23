package recursion;

//Given an array of distinct integers candidates and a target integer target,
// return a list of all unique combinations of candidates where the chosen numbers sum to target.
// You may return the combinations in any order.
//The same number may be chosen from candidates an unlimited number of times.
//Two combinations are unique if the frequency of at least one of the chosen numbers is different.

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static void main() {
        int[] arr = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationSum(arr, target, 0, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void findCombinationSum(int[] arr, int target,int index, List<List<Integer>> ans, List<Integer> subAns) {
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(subAns));
            }
            return;
        }
        if(arr[index] <= target){
            subAns.add(arr[index]);
            target = target - arr[index];
            findCombinationSum(arr,target, index, ans, subAns);
            subAns.removeLast();
            target = target+arr[index];
        }
        findCombinationSum(arr, target,index+1, ans, subAns);
    }
}
