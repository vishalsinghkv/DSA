package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPermutationsOptimal {
    static void main() {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(arr,0, ans);
        System.out.println(ans);
    }

    private static void findPermutations(int[] arr, int index, List<List<Integer>> ans) {
        if(index == arr.length){
            ans.add(Arrays.stream(arr).boxed().toList());
        }
            for(int j=index;j<arr.length;j++){
                swap(arr, index, j);
                findPermutations(arr, index+1, ans);
                swap(arr, j,index);
            }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
