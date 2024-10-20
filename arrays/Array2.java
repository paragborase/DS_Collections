package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Array2 {
    public static void main(String[] args) {
        // q1. Left rotate by one place
        // optimal *time complexity O(N) *space complexity O(1)
        int arr[] = { 1, 2, 3, 4, 5 };
        function1(arr);

        // q2. left rotate an array by D places
        int brr[] = { 1, 2, 3, 4, 5, 6, 7 };
        // brute force method *time complexity O(n+d) space complexity : O(d) (temp arr
        // extra space)
        function2(brr, 3);

        // optimal solution without using extra space i.e temp O(2N)
        int crr[] = { 1, 2, 3, 4, 5, 6, 7 };
        function3(crr, 3);

        // q3. moving zeros to end of array
        int drr[] = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        // brute force time complexity O(N) space complexity O(X) (best case) --> O(N)
        // (worst case)
        function4(drr);

        // optimal solution time complexity: O(N) space complexity: O(1) i.e No extra
        // space
        int err[] = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        function5(err);

        // q4. linear search find occcurence of number
        int frr[] = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        System.out.println(function6(frr, 4));

        // q5. find result and inetersection of two sorted arrays *time complexity
        // O(N1logn + N2logn) + O(N1+N2)
        int arr1[] = { 1, 1, 2, 3, 4, 5 };
        int arr2[] = { 2, 3, 4, 4, 5, 6 };
        // brute force
        function7(arr1, arr2); // *space complexity O(N1+N2) + O(N1+N2) (2nd one is used to return tha uni
                               // array) */

        // optimal solution time complexity: O(N1 + N2) space complexity O(N1+N2) (to
        // return data)
        function8(arr1, arr2, arr1.length, arr2.length);

        // q5. Intersection of two array
        int irr[] = { 1, 2, 2, 3, 3, 4, 5, 6 };
        int jrr[] = { 2, 3, 3, 5, 6, 6, 7 };
        // brute force approach time complexity O(N1 * N2) space complexity (O(N2))
        function10(irr, jrr, irr.length, jrr.length);

        // optimal solution time complexity O(N1 + N2) space complexity O(1)
        int krr[] = { 1, 2, 2, 3, 3, 4, 5, 6 };
        int lrr[] = { 2, 3, 3, 5, 6, 6, 7 };
        function11(krr, lrr, krr.length, lrr.length);
    }

    private static void function1(int[] arr) {
        System.out.println("Function1");
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;

        for (Integer a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void function2(int arr[], int shiftBy) {
        System.out.println("Function2");
        int n = arr.length;
        int d = shiftBy % n;
        int temp[] = new int[d];
        // temp creation O(d)
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }

        // shifting O(n-d)
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        // add last: place back temp to arr O(d)
        for (int i = (n - d); i < n; i++) {
            arr[i] = temp[i - (n - d)];
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void function3(int arr[], int shiftBy) {
        System.out.println("Function3:"); // total O(2N)
        reverseArray(arr, 0, shiftBy - 1); // O(d)
        reverseArray(arr, shiftBy, arr.length - 1); // O(n-d)
        reverseArray(arr, 0, arr.length - 1); // O(n)
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void reverseArray(int arr[], int start, int shiftBy) {
        int end = shiftBy;
        int temp = 0;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    private static void function4(int arr[]) {
        System.out.println("Function4: ");
        ArrayList<Integer> temp = new ArrayList(); // total : O(2N)
        for (int i = 0; i < arr.length; i++) { // O(N)
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        for (int i = 0; i < temp.size(); i++) { // O(X)
            arr[i] = temp.get(i);
        }

        for (int i = temp.size(); i < arr.length; i++) { // O(N-X)
            arr[i] = 0;
        }

        for (Object i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void function5(int arr[]) {
        System.out.println("Function5:");
        int j = -1;
        for (int i = 0; i < arr.length; i++) { // O(X)
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        int temp = 0;
        for (int i = j + 1; i < arr.length; i++) { // O(N-X)
            if (arr[i] != 0) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int function6(int arr[], int number) {
        System.out.println("Function6: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    private static void function8(int[] arr1, int[] arr2, int n, int m) {
        System.out.println("Function8:");
        int i = 0, j = 0; // pointers
        ArrayList<Integer> result = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (result.size() == 0 || result.get(result.size() - 1) != arr1[i])
                    result.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (result.size() == 0 || result.get(result.size() - 1) != arr2[j])
                    result.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // if any element left in arr1
        {
            if (result.get(result.size() - 1) != arr1[i])
                result.add(arr1[i]);
            i++;
        }
        while (j < m) // if any elements left in arr2
        {
            if (result.get(result.size() - 1) != arr2[j])
                result.add(arr2[j]);
            j++;
        }

        System.out.println(result);
        System.out.println();
    }

    private static void function7(int[] arr1, int[] arr2) {
        System.out.println("Function7:");
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) { // N1logN space complexity: N1
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) { // N2logN space complexity : N2
            set.add(arr2[i]);
        }
        int uni[] = new int[set.size()]; // space complexity O(N1+N2)

        int i = 0;
        for (int s : set) { // N1 + N2
            uni[i++] = s;
        }

        for (int s : uni) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void function10(int[] arr1, int[] arr2, int n, int m) {
        System.out.println("Function10:");
        int visit[] = new int[m];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j] && visit[j] == 0) {
                    ans.add(arr1[i]);
                    visit[j] = 1;
                    break;
                }

                if (arr2[j] > arr1[i])
                    break;
            }
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void function11(int[] arr1, int[] arr2, int n, int m) {
        System.out.println("Function 11: ");
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }

        for (int k : ans) {
            System.out.print(k + " ");
        }
    }
}
