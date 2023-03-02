import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueX
{
    public static void main(String arg[])
    {
        Queue<Integer> queue = new LinkedList<>();

        //.add() : Insert element in queue, if not throw Exception
        //To add the element without exception
        queue.offer(12);
        queue.offer(24);
        queue.offer(36);

        System.out.println(queue);
        //.remove() : To remove the element in Queue, if not throw exception
        //To remove the element without exception
        System.out.println(queue.poll());

        System.out.println(queue);

        //.element() : return head of queue , if not return exception
        System.out.println(queue.peek());

    }
}