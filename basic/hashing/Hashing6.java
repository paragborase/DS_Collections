package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//find highest frequecy element
public class Hashing6 {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,30,20,10,20,10};

        //1 function using hashing
        function(arr); 

        //2 Basic Method using stream function
        List<Integer> list = new ArrayList<>();
        for(int i : arr) {
            list.add(i);
        }
    }        

    //1 function using hashing
    private static void function(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        map.entrySet().stream().forEach(entry -> {
            list.add(entry.getValue());
        });
        Integer iMax = 0;
        Integer iMin = 0;
        for(int i = 0; i < list.size(); i++) {
            if(iMax < list.get(i)) {
                iMax = list.get(i);
            }
            if(iMin > list.get(i)) {
                iMin = list.get(i);
            }

        }
        System.out.println("highest occurence number is : "+iMax);
        System.out.println("lowest occurence number is : "+iMin);
    }
}
