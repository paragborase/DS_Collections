package recursion;
//reverse the array

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Recursion8 {
    public static void main(String[] args) {
        List<Integer> list = function3(Arrays.asList(10, 20,  30, 40, 50), 4, 0);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        List<Integer> list1 = Arrays.asList(10, 20,  30, 40, 50);
        function4(list1, 0, list1.size());
        for(int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i)+" ");
        }
    }

    // public static List<Integer> function1(List<Integer> list) {
    //     List<Integer> list1 = new ArrayList<>();
    //     for(int i = list.size()-1; i >= 0; i--) {
    //         System.out.println(list.get(i));
    //         list1.add(list.get(i));
    //     }
    //     return list1;
    // }

    // public static List<Integer> function2(List<Integer> list) {
    //     Integer last = list.size()-1;
    //     Integer integer;
    //     for(int i = 0; i < list.size(); i++) {
    //         integer = list.get(i);
    //          list.set(i, list.get(last));
    //          list.set(last, integer);
    //          if(last == i) {
    //             return list;
    //          }
    //          last--;
    //     }
    //     return list;
    // }

    //recursion
    public static List<Integer> function3(List<Integer> list, Integer last, Integer first) {
        if(last == first) {
            return list;
        }
        int integer = list.get(first);
        list.set(first, list.get(last));
        list.set(last, integer);
        function3(list, last-1, first+1);
        return list;
    }
    //recursion
    public static void function4(List<Integer> list, int i, int n) {
        if(i >= n/2) {
            return;
        }
        Collections.swap(list, i, (n-i-1));
        function4(list, i+1, n);
    }
}
