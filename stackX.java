import java.util.Stack;
import java.util.Iterator;

public class stackX
{
    public static void main(String Arr[])
    {
        Stack<String> names = new Stack<>();

        names.push("King");
        names.push("ABC");
        names.push("XYZ");
        names.push("Tiger");
        names.push("XYZ");

        System.out.println("stack is : "+names);

        //To check uppermost element
        System.out.println(names.peek()); //XYZ

        names.pop();
        System.out.println(names.peek()); //Tiger

        //check Whether stack is empty or not
        System.out.println(names.empty());
        
        //To search Top to down approch
        System.out.println(names.search("ABC"));   //3

        //Using Interator 
        Iterator<String> iobj = names.iterator();
        while(iobj.hasNext())
        {
            System.out.println("Iterator is "+iobj.next());
        }

        //using for each loop
        for(String name : names)
        {
            System.out.println("Iterator is "+name);
        }
    }
}
