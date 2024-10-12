package sorting;

public class Sorting4 {
    public static void main(String[] args) {

        System.out.println("Selection sort: ");
        int[] arr = {12, 46, 24, 52, 20, 9};
        selection_sort(arr);

        System.out.println("Bubble Sort: ");
        int[] brr = {12, 46, 24, 52, 20, 9};
        bubble_sort(brr);

        System.out.println("Insertion Sort: ");
        int[] crr = {12, 46, 24, 52, 20, 9};
        inserion_sort(crr);

    }

    //time complexity:
    //worst, average and best case : O(N Power of 2)
    private static void inserion_sort(int[] crr) {
        int n = crr.length;
        int temp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(crr[i] > crr[j]) {
                    temp = crr[i];
                    crr[i] = crr[j];
                    crr[j] = temp;
                }
            }
        }

        for(int i : crr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //time complexity
    //worst and average case : O(N Power of 2)
    //best case (i.e Asending Array) O(N)
    private static void bubble_sort(int[] brr) {
        int n = brr.length;
        int temp = 0;
        int swap = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n-i; j++) {
                if(brr[j-1] > brr[j]) {
                    temp = brr[j-1];
                    brr[j-1] = brr[j];
                    brr[j] = temp;
                    swap = 1;
                }
            }
            if(swap == 0) {
                break;
            }
        }

        for(int i : brr){
            System.out.print(i+" ");
        }
        System.out.println();
    }


    //time Complexity
    //worst & Average case : O(N Power of 2)
    //best Case (i.e. Asending Array): O(N)  
    private static void selection_sort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            j = i;
            while(j > 0 && arr[j-1] > arr[j]) {
                temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }

        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
