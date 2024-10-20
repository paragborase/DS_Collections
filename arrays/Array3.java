package arrays;

public class Array3 {
    public static void main(String[] args) {
        // q1. find missing number
        int arr[] = { 1, 2, 4, 5 };
        // brute force solution time complexity : O(N*N) (worst case) space complexity
        // O(1)
        function1(arr);
        // better solution *time complexity O(N) + O(N) (because two separate loop)
        // *space complexity O(N)
        int brr[] = { 1, 2, 4, 5 };
        function2(brr);
        // optimal solution 1: time complexity: O(N)
        int crr[] = { 1, 2, 4, 5 };
        function3(crr);

        // q2. maximun consecutive one time complexity O(N)
        int drr[] = { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1 };
        function4(drr);

        // q3. find the number that appear once, and other number twice
        int err[] = { 1, 1, 2, 3, 3, 4, 4 };
        // brute force *iterate each element as check count *time complexity O(N*N)
        // better solution time complexity O(N+N)
        function5(err);
        // optimal solution (xor) *time complexity O(N) and space complexity : O(1)
        int frr[] = { 1, 1, 2, 3, 3, 4, 4 };
        function6(frr);

    }

    private static void function1(int[] arr) {
        System.out.println("Function1:");
        int iAns = 0;
        int flag = 0;
        for (int i = 1; i <= arr.length; i++) {
            flag = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                iAns = i;
                break;
            }
        }
        System.out.println("Number doesnt exist is : " + iAns);
    }

    private static void function2(int[] arr) {
        System.out.println("Function2:");
        int[] hash = new int[arr.length + 2];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] = 1;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            if (hash[i] == 0) {
                System.out.println("Number is not present in hash is " + i);
            }
        }
    }

    private static void function3(int[] crr) {
        System.out.println("Function3:");
        int count = crr.length + 1;
        int iSum = count * (count + 1) / 2;
        int iTotal = 0;
        for (int i : crr) {
            iTotal = iTotal + i;
        }
        System.out.println("Missing nunber is arrays is : " + (iSum - iTotal));
    }

    private static void function4(int[] drr) {
        int iAns = 0;
        int iMax = 0;
        for (int i : drr) {
            if (i == 1) {
                iAns++;
            } else if (i == 0) {
                iAns = 0;
            }
            // if (iMax < iAns) {
            // iMax = iAns;
            // }
            iMax = Math.max(iMax, iAns);
        }
        System.out.println("Number of maximun consecutive nunber is : " + iMax);
    }

    private static void function5(int[] arr) {
        System.out.println("Function5:");
        int hash[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        int j = 0;
        for (int i : hash) {
            if (i != 0) {
                System.out.println(j + " Number present in arr are count " + i);
            }
            j++;
        }

    }

    private static void function6(int[] arr) {
        System.out.println("Function7: ");
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        System.out.println("number that appear once is : " + xor);
    }

}
