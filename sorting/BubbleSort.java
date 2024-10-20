public class BubbleSort {
    public static void main(String[] args) {
        int[] brr = {12, 46, 24, 52, 20, 9};
        System.out.println("Array before sorting: ");
        for(int i : brr) {
            System.out.print(i+" ");
        }
        System.out.println();

        bubble_sort(brr);
        
        System.out.println("Array after sorting: ");
        for(int i : brr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //time complexity
    //worst and average case : O(Nˆ2)
    //best case (i.e Asending Array) O(N)
    private static void bubble_sort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        int breaker = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n - i; j++) {
                if(arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    breaker = 1;
                }
            }
            if(breaker == 0) {
                break;
            }
        }
    }
}
