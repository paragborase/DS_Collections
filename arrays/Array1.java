package arrays;

import java.util.HashSet;
import java.util.Set;

public class Array1 {
    public static void main(String[] args) {
        // q1. find largest element
        // brute force approach (sorting + finding) *time complexity N^2 or N(logN)
        int arr[] = { 3, 2, 1, 5, 2 };
        function1(arr);
        // Optimal *time complexity O(N)
        int brr[] = { 3, 2, 1, 5, 2 };
        function2(brr);

        // q2. find second largest
        // brute force approch (sorting (N(logN)) + worst case(N)) *time complexity
        // (N(logN) + N)
        int crr[] = { 1, 2, 4, 7, 7, 5 };
        function3(crr);

        // better solution *time complexity O(N) + O(N) = O(2N)
        int drr[] = { 1, 2, 4, 7, 7, 5 };
        function4(drr);

        // optimal solution *time complexity : O
        // second largest
        int err[] = { 1, 2, 4, 7, 7, 5 };
        function5(err);
        // second smallest
        function6(err);

        // q3. check if array is sorted time complexity: O(N)
        int frr[] = { 1, 2, 2, 3, 4, 4 };
        boolean ans = function7(frr);
        System.out.println(ans == true ? "Sorted Array" : "Not sorted");

        // q4. remove duplicate in place from sorted array *time complexity (NlogN + N)
        // brute force approch
        int grr[] = { 1, 1, 2, 2, 2, 3, 3 };
        function8(grr);

        // optimal solution *time complexity O(N) *space complexity O(1)
        int hrr[] = { 1, 1, 2, 2, 2, 3, 3 };
        function9(hrr);
    }

    private static void function1(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Sorting
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // find largest element
        System.out.println("Largest element of array using brute force is : " + arr[arr.length - 1]);
    }

    private static void function2(int[] arr) {
        int iMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (iMax < arr[i]) {
                iMax = arr[i];
            }
        }
        System.out.println("Largest number in array using optimal : " + iMax);
    }

    public static void function3(int arr[]) {
        int temp = 0; // sorting
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // {1, 2, 4, 5, 7, 7} array after sorting
        int largest = arr[arr.length - 1];
        int secondLargest = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }
        }
        System.out.println("Second largest elememnt in arrays : " + secondLargest);
    }

    public static void function4(int arr[]) {
        int iLargest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > iLargest) {
                iLargest = arr[i];
            }
        }
        System.out.println("Largest number is : " + iLargest);

        int secondLargest = -1; // assuming all elements in array are positive
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] != iLargest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("Seocnd Largest element in array is : " + secondLargest);
    }

    public static void function5(int arr[]) {
        int iLargest = arr[0];
        int secondLargest = -1; // assuming all element in array is positive, if its negative then consider as
                                // Min_Int or any lower number
        for (int i = 1; i < arr.length; i++) {
            if (iLargest < arr[i]) {
                secondLargest = iLargest;
                iLargest = arr[i];
            } else if ((arr[i] < iLargest) && (arr[i] > secondLargest)) {
                secondLargest = arr[i];
            }
        }
        System.out.println("second largest element in array is : " + secondLargest);
    }

    public static void function6(int arr[]) {
        int iSmallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE; // ***/
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < iSmallest) {
                secondSmallest = iSmallest;
                iSmallest = arr[i];
            } else if ((arr[i] > iSmallest) && (arr[i] < secondSmallest)) {
                secondSmallest = arr[i];
            }
        }
        System.out.println("second smallest number is array : " + secondSmallest);
    }

    public static boolean function7(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
            // OR
            // if(arr[i - 1] <= arr[i]) {

            // } else {
            // return false;
            // }
        }
        return true;
    }

    public static void function8(int arr[]) {
        Set<Integer> set = new HashSet<>();
        // time complexity: (NlogN)
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]); // insert into set (logN)
        }
        int index = 0;
        // time complexity: N
        for (Integer newn : set) {
            arr[index] = newn;
            index++;
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void function9(int arr[]) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        System.out.println("Total number of unique element in array is : " + (i + 1));
    }

}
