import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

class ArrayListX
{
    public static void main(String arr[])
    {
        ArrayList<String> StudentsName = new ArrayList<>();
        StudentsName.add("Parag");
        StudentsName.add("Jack");
        StudentsName.add("Hari");
        System.out.println(StudentsName);
        //size n   ex.10
        //new allocated size n + n/2 + 1  ex.16

        List<Integer> ListInt = new ArrayList<>();
        ListInt.add(1);
        ListInt.add(4);
        ListInt.add(2);
        ListInt.add(3);
        ListInt.add(4);
        ListInt.add(5);
        ListInt.add(4);
        System.out.println(ListInt);

        ListInt.add(1,50);
        System.out.println(ListInt);

        List<Integer> NewList = new ArrayList<>();
        NewList.add(150);
        NewList.add(160);

        ListInt.addAll(NewList);
        System.out.println(ListInt);

        //To get element
        System.out.println(ListInt.get(1));

        //Remove 1st index element
        ListInt.remove(1);
        System.out.println(ListInt);

        //Remove value of element 
        ListInt.remove(Integer.valueOf(4));   //This will rmeove First elemenet If Mulitple element exist
        System.out.println(ListInt);
        
        //To set new element
        ListInt.set(2,1000);
        System.out.println(ListInt);
        //contain true or false Check existance of elemenet
        System.out.println(ListInt.contains(50));


        //Interate ArrayList
        for(int i = 0; i < ListInt.size(); i++)
        {
            System.out.println("elemenet is  "+ListInt.get(i));
        }   

        //using for each loop
        for(Integer elemenet: ListInt)
        {
            System.out.println("elemenet is  "+elemenet);
        }

        //Using Interator 
        Iterator<Integer> iobj = ListInt.iterator();
        while(iobj.hasNext())
        {
            System.out.println("Interator is "+iobj.next());
        }

        ListInt.clear();
        System.out.println(ListInt);

    }
}