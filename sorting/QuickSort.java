class Solution {
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp = 0;
        while(i < j) {
            while(arr[i] <= pivot && i <= high) {
                i++;
            }

            while(arr[j] > pivot && j >= low) {
                j--;
            }

            if(i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap
        temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        return j;
    }

    public static void qs(int arr[], int low, int high) {
        if(low < high) {
            int partition_index = partition(arr, low, high);
            qs(arr, low, partition_index - 1);
            qs(arr, partition_index + 1, high);
        }
    }
}

//time complexity: N(logN)
//space complexity: O(1) //not taking recursive stack space in consideration
public class QuickSort {
        public static void main(String[] args) {
            int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
            int n = arr.length;
            System.out.println("Before sorting array: ");
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
    
            System.out.println();
            Solution.qs(arr, 0, n-1);
            System.out.println("After quick sorting array will be: ");
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        //solution
        //Before sorting array: 
        // 4 6 2 5 7 9 1 3 
        //After quick sorting array will be:  
        // 1 2 3 4 5 6 7 9 
}
