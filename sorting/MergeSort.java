package sorting;

import java.util.ArrayList;

class Result {
    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();  //storing element in sorted array
        int left = low; //starting index of left half of arr
        int right = mid + 1; //starting index of right half of arr

        
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        //if element from left half still left
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //if element on the right half still left
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }

        //transfering all element from temp to arr
        for(int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

    }
    public static void mergeSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low + high) /2;
        mergeSort(arr, low, mid); 
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
}
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 3};
        int n = arr.length;
        System.out.println("Before sorting array: ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println();
        Result.mergeSort(arr, 0, n-1);
        System.out.println("After Merge Sorting Array: ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
