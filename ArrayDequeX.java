import java.util.ArrayDeque;

public class ArrayDequeX
{
    public static void main(String arr[])
    {
        ArrayDeque<Integer> pq = new ArrayDeque<>();

        pq.offer(23);
        pq.offerFirst(12);
        pq.offerLast(25);
        pq.offer(26);

        System.out.println(pq);

        // System.out.println(pq.peek());
        // System.out.println(pq.peekFirst());
        // System.out.println(pq.peekLast());

        // System.out.println(pq.poll());
        // System.out.println("Poll is : "+pq);

        // System.out.println(pq.pollFirst());
        // System.out.println("pollFirst is : "+pq);

        // System.out.println(pq.pollLast());
        // System.out.println("pollLast is : "+pq);


    }
}