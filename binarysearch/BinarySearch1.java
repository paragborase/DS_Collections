package binarysearch;

public class BinarySearch1 {

    public static void main(String[] args) {
        // q1. binary search iterative approach, return index
        int[] arr = { 1, 3, 7, 9, 11, 12, 45 };
        int target = 3;
        int index = function1(arr, target);
        System.out.println("index value is " + index + " that is target value " + arr[index]);
        System.out.println();

        // recursive approach *time complexity O(log base 2 N) i.e. O(log2(N))
        // e.g 32 = 32 -step1> 16 -step2> 8 -step3> 4 -step4> 2 -step5> 1 (i.e around 6
        // steps to find out target)
        // O(log2(32)) -> O(log2(2*5)) -> O(5 (log2(2))) -> 5 * 1=> 5
        int[] brr = { 1, 3, 7, 9, 11, 12, 45 };
        int target1 = 13;
        index = function2(brr, 0, arr.length - 1, target1);
        System.out.println("index value is " + index + " that is target value " + target1);
        System.out.println();

        // overflow cases
        // if search space is INT-MAX * mid = low + (high - low)/2

    }

    private static int function1(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int function2(int arr[], int low, int high, int target) {
        if (low > high) { // base case
            return -1;
        }
        int mid = (low + high) / 2;
        if (target == arr[mid]) {
            return mid;
        } else if (target > arr[mid]) {
            return function2(arr, mid + 1, high, target);
        }
        return function2(arr, low, mid - 1, target);
    }
}
