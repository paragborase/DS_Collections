import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueX
{
    public static void main(String arr[])
    {
        //Queue<Integer> pq = new PriorityQueue<>();
        //Comparator.reverseOrder To reverseOrder natural number
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.offer(40);
        pq.offer(36);
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);
        pq.offer(36);

        System.out.println(pq);
        //Remove element
        pq.poll();
        System.out.println(pq);

        //get head element
        System.out.println(pq.peek());

        System.out.println(pq);
    }
}