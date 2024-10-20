package recursion;

import java.util.ArrayList;
import java.util.List;

//Fibonacci number
public class Recursion10 {
    public static void main(String[] args) {
        List<Integer> list = function1();
        for(Integer no: list) {
            System.out.print(no+" ");
        }
        System.out.println();
        Integer number = function2(4);
        System.out.println(4+" Fibonacci number is "+number);
    }

    public static List<Integer> function1() {
        List<Integer> list = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
            if (i == 0) {
                resultList.add(i);
            } else if (i == 1) {
                resultList.add(i);
            } else {
                resultList.add((resultList.get(i-2) + resultList.get(i-1)));
            }
        }
        return resultList;
    }

    public static Integer function2(Integer no) {
        if(no <= 1) {
            return no;
        }
        return function2(no-1) + function2(no-2);
    }
}
