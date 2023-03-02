import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class LinkedListX
{
    public static void main(String arg[])
    {
        List<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);

        list.add(1,10);
        System.out.println(list.size());

        //remove
        list.remove(3);   //index
        System.out.println("after removing new List"+list);

        //Adding element in middle of linked list
        list.add(3,11);

        System.out.println(list.get(3));

        list.set(5,12);

        System.out.println("after changing values: "+list);

        System.out.println(list.contains(5));

        //Check whether list is isEmpty
        System.out.println(list.isEmpty());

        //sort using collection
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(5);
        list1.add(2);
        list1.add(11);

        System.out.println("Before sorting : "+list1);
        Collections.sort(list1);
        System.out.println("After sorting : "+list1);

        //shuffle
        Collections.shuffle(list);
    }
}