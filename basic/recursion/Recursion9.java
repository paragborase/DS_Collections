package recursion;

public class Recursion9 {
    public static void main(String[] args) {
        String str = "MNNDDNNM";
        boolean check = function1(str, 0, str.length());
        if(check) {
            System.out.println("Palindrom String");
        } else {
            System.out.println("Not a palidrome string");
        }
    }

    public static boolean function1(String str, int i, int n) {
        if(i >= n/2) {
            return true;
        }
        if(str.charAt(i) != str.charAt(n-i-1)) {
            return false;
        }
        return function1(str, i+1, n);
    }
}
