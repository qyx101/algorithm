package Queue1;

public class Test {
    public static void main(String[] args) {
        Queue1<String> queue1 = new Queue1<String>();
        queue1.offer("a");
        queue1.offer("b");
        queue1.offer("c");
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
    }
}
