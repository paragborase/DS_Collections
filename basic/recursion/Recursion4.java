package recursion;

import java.util.Scanner;

public class Recursion4 {
    public static void main(String[] args) {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter the number: ");
        Integer iNo = sobj.nextInt();

        function(5, iNo);
    }

    public static void function(Integer i, Integer count) {
        if(i <= 0) {
            return;
        }
        function(i-1, count);
        System.out.println(i);
    }
}
