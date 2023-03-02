import java.util.LinkedHashSet;
//import java.util.Set;

public class LinkedHashSetX
{
    public static void main(String arr[])
    {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

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