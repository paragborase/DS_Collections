package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//character hashing
public class Hashing5 {
    public static void main(String[] args) {
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter the number Arrays Size: ");

        Integer arrSize = sobj.nextInt();
        Integer[] arr = new Integer[arrSize];

        System.out.println("Enter the element of Array: ");

        //pre-compute as well as taking input
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sobj.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //combining two step will not cause program faster because previously running two loop i.e. (N + N) ; (N + N) -> N not much difference
        //saving one for loop will not impact that much

        //It will imapct if complexity is (N * N)

        //System.out.println(map);

        //map.forEach((key, value) -> {
        //    System.out.println("Key : "+key+" value : "+value);
        //});

        map.entrySet().stream().forEach(entry -> System.out.println(" key "+entry.getKey()+" value "+entry.getValue()));        
    }
}
