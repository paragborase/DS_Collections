import java.util.HashMap;
import java.util.Map;

public class HashMap_X {

    public static void main(String arg[])
    {
        Map<String, Integer> numbers = new HashMap<String, Integer>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);

        //numbers.put("Two", 23);   Value is overided if we again put same key Data

        if(!numbers.containsKey("Two"))
        {
            numbers.put("Two", 23);
        }

        numbers.remove("Three");
        //OR 
        //If "Two" Key value absent then only add new element
        numbers.putIfAbsent("Two", 23);

        System.out.println(numbers);

        //Interate
        for (Map.Entry<String,Integer> e: numbers.entrySet()){
            System.out.println(e);

            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        //Tocheck Value
        System.out.println(numbers.containsValue(3));
        System.out.println(numbers.isEmpty());
    }
}
