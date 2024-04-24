import java.util.HashMap;
import java.util.HashSet;

// HashSet 、 Hashmap 基本使用

class Test {

    static class Student {
        int age;
        String name;

        public Student(String name,int age) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student stu1 = new Student("张三",18);
        Student stu2 = new Student("张三",19);
        HashMap<Student,String> map = new HashMap<>();
        map.put(stu1,"张三");

        // true
        System.out.println(map.containsKey(stu1));

        // false - 自己定义的类, HashMap是用对象地址做key，而不是值
        System.out.println(map.containsKey(stu2));

        map.put(stu2,"这是另一个张三");
        // 2
        System.out.println(map.size());
        // 张三
        System.out.println(map.get(stu1));
        // 另一个张三
        System.out.println(map.get(stu2));

    }

    // Hashmap 基本使用
    public static void main2(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        HashMap<String,String> map = new HashMap<>();
        map.put(str1,"World");

        // 1. true - 拿值作为key, 查找value
        System.out.println(map.containsKey("Hello"));
        System.out.println(map.containsKey(str1));
        System.out.println(map.get("Hello"));
        System.out.println(map.get(str1));

        // 2. null —— key不存在, 返回null
        System.out.println(map.get("hello"));
    }

    // HashSet 基本使用
    public static void main1(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        // 1. false —— == 比较的是地址
        System.out.println(str1 == str2);
        // 2. true —— String类中重写的equal方法, 比较的是值
        System.out.println(str1.equals(str2));


        HashSet<String> set = new HashSet<>();
        set.add(str1);
        // 3. true
        System.out.println(set.contains("Hello"));
        // 4. true —— 根据值去查找
        System.out.println(set.contains(str2));

        // 5. 1 —— 根据, 值做Key, set内部只存储一份key
        set.add(str2);
        System.out.println(set.size());
    }
}