package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//character hashing
public class Hashing4 {
    public static void main(String[] args) {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter the number Arrays Size: ");
        Integer arrSize = sobj.nextInt();
        Integer[] arr = new Integer[arrSize];
        System.out.println("Enter the element of Array: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sobj.nextInt();
        }

        //pre-compute
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arrSize; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //System.out.println(map);

        //map.forEach((key, value) -> {
        //    System.out.println("Key : "+key+" value : "+value);
        //});

        map.entrySet().stream().forEach(entry -> System.out.println(" key "+entry.getKey()+" value "+entry.getValue()));
    }
}
