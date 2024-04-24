package demo1;

public class Test {

    public static void main(String[] args) {
        HashBuck2<Student,Integer> hashBuck2 = new HashBuck2<>();
        Student student1 = new Student("007abc");
        hashBuck2.push(student1,18);
        hashBuck2.push(student1,19);
    }

    public static void main2(String[] args) {
        Student student1 = new Student("007abc");
        System.out.println(student1.hashCode());

        Student student2 = new Student("a");
        System.out.println(student2.hashCode());

    }

    public static void main1(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.push(1,1);
        hashBuck.push(2,2);
        hashBuck.push(3,3);
        hashBuck.push(4,4);
        hashBuck.push(5,5);
        hashBuck.push(6,6);
        hashBuck.push(14,14);
        hashBuck.push(7,7);

        System.err.println(hashBuck.get(16));
    }
}
