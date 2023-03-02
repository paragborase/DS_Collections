import java.util.HashSet;
//import java.util.Set;

public class HashSetX
{
    public static void main(String arr[])
    {
        HashSet<Integer> set = new HashSet<>();

        set.add(32);
        set.add(12);
        set.add(24);

        //set.add(24);  Not Allowed
        //set.add(24);  Not allowed
        System.out.println(set); 

        set.remove(24);
        System.out.println(set); 

        System.out.println(set.contains(12));
        System.out.println(set.size());
        set.clear();
        System.out.println(set); 
    }
}