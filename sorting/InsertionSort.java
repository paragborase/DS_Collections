public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 46, 24, 52, 20, 9};
        System.out.println("Array before sorting: ");
        for(int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();

        insertion_sort(arr);

        System.out.println("Array after sorting: ");
        for(int i : arr) {
            System.out.print(i+" ");
        }
    }

    //time complexity
    //worst and average case : O(Nˆ2)
    //best case (i.e Asending Array) O(N)
    //hint: create an array (1...n-1) 
    public static void insertion_sort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            j = i;
            while(j > 0 && arr[j-1] > arr[j]) {
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }

            j--;
        }   
    }
}
