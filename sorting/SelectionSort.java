public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {12, 46, 24, 52, 20, 9};
        System.out.println("Array before sorting: ");
        for(int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();

        selection_sort(arr);

        System.out.println("Array after sorting: ");
        for(int i : arr) {
            System.out.print(i+" ");
        }
    }

    //time Complexity
    //worst, average and best case : O(Nˆ2)
    //hint: check min and replace
    private static void selection_sort(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
