package binarysearch;

public class BinarySearch3 {

    public static void main(String[] args) {
        // q.1 first and last position of an element in sorted array
        // time complexity 2*O(log2(N)) *space complexity O(1)
        // arr consist of N element and provided int k to find first and last occurence
        // 1. If k is not present in array then first and last occurence will be -1
        // 2. array may contain duplicate element

        int k = 8;
        int arr[] = { 2, 4, 6, 8, 8, 8, 11, 13 };
        int firstOccurence = lowerBound(arr, k);
        int lastOccurence = upperBound(arr, k) - 1;
        if (firstOccurence == arr.length || arr[firstOccurence] != k) {
            System.out.println("first and last occurence is : " + " -1, -1");
        } else {
            System.out.println("first and last occurence is : " + firstOccurence + " and " + lastOccurence);
        }

        // method 2: instead of lower bound and upper bound plan binary search code
        // firstOccurence
        int brr[] = { 2, 6, 8, 8, 8, 11, 13 };
        k = 8;
        int first = firstoccurence(brr, k); // if firstoccurence is return value is -1 then no need to find
                                            // lastoccurence
        int last = lastoccurence(brr, k);
        if (first == -1) {
            System.out.println("First and last occurence is :" + -1);
        } else {
            System.out.println(" First occurence is : " + first + "\n" + " last occurence is : " + last);
        }

        // q2. count occurence of a number in a sorted array with duplicates
        int count = (last - first) + 1;
        System.out.println(" For number " + k + " occurence count is " + count);
    }

    private static int firstoccurence(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int first = -1; // default if element is not found
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private static int lastoccurence(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
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
