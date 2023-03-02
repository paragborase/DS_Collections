//import java.util.*;

class Array
{
    public static void main(String arr[])
    {
        String[] StudentName = new String[30];
        StudentName[0] = "Parag";
        //Add Multiple Names upto [0] to [29]
        StudentName[29] = "Hari";

        //To add Student after 29 index    //ArrayIndexOutOfBoundsException
        StudentName[30] = "Jonathan";
    }
}