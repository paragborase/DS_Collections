package hashing;

import java.util.Scanner;
//Number hashing -> arrays
public class Hashing {
    public static void main(String[] args) {
        Scanner sobj = new Scanner(System.in);
        Integer size = sobj.nextInt();
        Integer[] arr = new Integer[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sobj.nextInt();
        }

        //precompute
        int[] hash = new int[13];
        for(int i = 0; i < size; i++) {
            hash[arr[i]] += 1;
        }

        //Integer number = sobj.nextInt();
        for(Integer i = 0; i < 5; i++) {
            Integer iNo = i;

            //Fetch
            System.out.println(" "+iNo+" occurence in array count is "+hash[iNo]);
        }
    }
}
