package recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutations {
    static void main() {
        int[] arr = {1,2,3};
        boolean[] picked = new boolean[arr.length];
        List<List<Integer>> ans = new ArrayList<>();
        findAllPermutations(arr, picked, ans, new ArrayList<>());
        System.out.println(ans);
    }

    // TC -> O(n! * n), SC -> O(n) + O(n) = O(n)
    private static void findAllPermutations(int[] arr, boolean[] picked, List<List<Integer>> ans, ArrayList<Integer> subAns) {
        if(subAns.size() == arr.length){
            ans.add(new ArrayList<>(subAns));
            return;
        }
        for(int i=0;i< arr.length;i++){
            if(!picked[i]){
                picked[i] = true;
                subAns.add(arr[i]);
                findAllPermutations(arr, picked, ans, subAns);
                subAns.removeLast();
                picked[i] = false;
            }
        }
    }
}
