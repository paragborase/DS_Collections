package recursion;

import java.util.Scanner;

public class Recursion2 {
    public static void main(String[] args) {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter the number : ");
        Integer iNo = sobj.nextInt();

        function(1, iNo);
    }

    private static void function(Integer i, Integer iNo) {
        if(i > iNo) {
            return;
        }
        System.out.println("Number");
        function(i+1, iNo);
    }
}
