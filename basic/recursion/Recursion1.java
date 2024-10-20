package recursion;

import java.util.Scanner;

public class Recursion1 {
    public static void main(String[] args) {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Please enter the number: ");
        Integer iNo = sobj.nextInt();

        function(iNo);
    }

    private static void function(int iNo) {
        if(iNo == 10000) {
            return;
        }
        System.out.println(iNo);
        iNo++;
        function(iNo);
    }
}
