import java.util.TreeSet;
//import java.util.Set;

public class TreeSetX
{
    public static void main(String arr[])
    {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(32);
        set.add(12);
        set.add(24);

        //set.add(24);  Not Allowed
        //set.add(24);  Not allowed
        System.out.println(set); 
        //set.add(null);  //java.lang.NullPointerException //NOT allowed

        set.remove(24);
        System.out.println(set); 

        System.out.println(set.contains(12));
        System.out.println(set.size());
        set.clear();
        System.out.println(set); 
    }
}