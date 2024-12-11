package binarysearch;

public class BinarySearch2 {

    public static void main(String[] args) {
        // Lower bound : smallest index such that arr[index] >= target
        // if lower bound return is not found then always return hypothetical index i.e.
        // arr.length;
        int[] arr = { 1, 3, 7, 9, 11, 12, 45 };
        int target = 3;
        int index = lowerBound(arr, target);
        System.out.println("Lower bound index will be : " + index);

        // upper bound : smallest index such that arr[index] > target
        int[] brr = { 1, 3, 7, 9, 11, 12, 45 };
        int target1 = 3;
        int index1 = upperBound(brr, target1);
        System.out.println("Lower bound index will be : " + index1);

        // search insert position
        // if value is present in array , then return its index
        // if value is not present, determine the index where it would be inserted in
        // the array maintaining sorted order
        int[] crr = { 1, 3, 7, 9, 11, 12, 45 };
        int element = 2;
        int index2 = searchInsert(crr, element);
        System.out.println("search insert index will be : " + index2);

        // Floor and ceil
        // floor : largest no in array <= X;
        // ceil : smallest number in array >= X;
        // int[] drr = {10, 20, 30, 40, 50}; int x = 25; // floor is 20 // ceil is 30
        int[] drr = { 10, 20, 30, 40, 50 };
        element = 25;
        int element1 = floor(drr, element);
        System.out.println("Floor element is : " + element1);
        int element2 = ceil(drr, element);
        System.out.println("ceil element is : " + element2);
    }

    private static int ceil(int[] drr, int element) { // exact similar to lower bound
        int low = 0;
        int high = drr.length - 1;
        int ans = -1; // in case of ceil set ans as -1
        while (low <= high) {
            int mid = (low + high) / 2;
            if (drr[mid] >= element) {
                ans = drr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int floor(int[] drr, int element) {
        int low = 0;
        int high = drr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (drr[mid] <= element) {
                ans = drr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int searchInsert(int[] crr, int element) {
        int low = 0;
        int high = crr.length - 1;
        int ans = crr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (crr[mid] >= element) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
