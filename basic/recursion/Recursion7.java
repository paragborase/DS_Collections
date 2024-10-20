package recursion;
//Factorial using recursion
public class Recursion7 {
    public static void main(String[] args) {
        Integer fact = 1;
        paramterized(4, fact);
        System.out.println("Factorial using recursion: "+functional(5));
    }

    public static void paramterized(Integer i, Integer fact) {
        if(i < 1) {
            System.out.println("Factorial of Number is: "+fact);
            return;
        }
        fact = fact * (i);
        paramterized(i-1, fact);
    }

    public static Integer functional(Integer fact) {
        if(fact == 0) {
            return 1;
        }
        fact = fact * functional(fact-1);
        return fact;
    }
}
