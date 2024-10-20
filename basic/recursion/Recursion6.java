package recursion;

public class Recursion6 {
    public static void main(String[] args) {
        paramterized(5, 0);
        Integer iNumber = functional(5);
        System.out.println("Addition through function recursion call is : "+iNumber);
    }

    public static void paramterized(Integer i, Integer iSum) {
        if (i < 1) {
            System.out.println(iSum);
            return;
        }
        iSum = iSum + i;
        paramterized(i-1, iSum+1);
    }

    public static Integer functional(Integer n) {
        if(n == 0) {
            return 0;
        }
        return n + functional(n-1);
    }
}
