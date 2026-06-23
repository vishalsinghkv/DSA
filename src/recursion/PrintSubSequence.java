//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int[] arr = {3,2,1,4};
    printSubsequence(arr,0, new ArrayList<>());
}

void printSubsequence(int[] arr, int i, List<Integer> subArr){
    if(i == arr.length){
        System.out.println(subArr);
        return;
    }
    subArr.add(arr[i]);
    printSubsequence(arr,i+1,subArr);
    subArr.removeLast();
    printSubsequence(arr, i+1, subArr);
}


