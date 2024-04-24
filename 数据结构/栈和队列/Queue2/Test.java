package Queue2;

public class Test {
    public static void main(String[] args) {
        Queue2<Integer> queue2 = new Queue2<Integer>(5);
        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(3);
        queue2.offer(4);
        queue2.offer(5);
        System.out.println(queue2.poll());
        System.out.println(queue2.head());
        System.out.println(queue2.tail());
    }
}
