package demo;

import java.util.*;

public class UseComparator {


    // [10,4]
    // 谁小, 谁优先级高
    // 原理: 返回负数认为o1的优先级更高
    // o1(4) - o2(10)  >= 0, break;
    // else: swap(o1,o2);

    // 谁大, 谁优先级高
    // 原理: 返回正数认为o2的优先级更高
    // o2(10) - o1(4)  >= 0, break;
    // else: swap(o1,o2);



    // 例子1: PriorityQueue 建大根堆
    static class Cmp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public static void main1(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Cmp());
        heap.offer(10);
        heap.offer(4);
    }


    // 例子2:
    static class Employee {
        public int company;
        public int age;

        public Employee(int company, int age) {
            this.company = company;
            this.age = age;
        }
    }

    // [10,4}
    public static class EmployeeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            // 谁小, 谁优先级高
            //return o1.age - o2.age;

            // 谁大,谁优先级高
            return o2.age - o1.age;
        }

    }

    public static void main2(String[] args) {
        Employee s1 = new Employee(2, 27);
        Employee s2 = new Employee(1, 60);
        Employee s3 = new Employee(4, 19);
        Employee s4 = new Employee(3, 23);
        Employee s5 = new Employee(1, 35);
        Employee s6 = new Employee(3, 55);
        Employee[] arr = { s1, s2, s3, s4, s5, s6 };

        Arrays.sort(arr, new EmployeeComparator());

        for (Employee e : arr) {
            System.out.println(e.company + " , " + e.age);
        }
    }

    // 例子3: 上面的例子, 用lambda表达式简写
    public static void main3(String[] args) {
        Employee s1 = new Employee(2, 27);
        Employee s2 = new Employee(1, 60);
        Employee s3 = new Employee(4, 19);
        Employee s4 = new Employee(3, 23);
        Employee s5 = new Employee(1, 35);
        Employee s6 = new Employee(3, 55);
        Employee[] arr = { s1, s2, s3, s4, s5, s6 };

        // 用lambda表达式简写
        // 谁大,谁优先级高
        Arrays.sort(arr, (o1,o2) -> o2.age - o1.age);

        for (Employee e : arr) {
            System.out.println(e.company + " , " + e.age);
        }

        System.out.println("====================");
        System.out.println("====================");

        // 所有员工，先按照谁的公司编号小，谁在前；如果公司编号一样，谁年龄小谁在前
        Arrays.sort(arr, (o1,o2) ->
                (o1.company != o2.company) ? o1.company - o2.company
                        : o1.age - o2.age);
        for (Employee e : arr) {
            System.out.println(e.company + " , " + e.age);
        }

        System.out.println("====================");
        System.out.println("====================");

        // 如果是自定义类型, 必须得传入比较器
        TreeSet<Employee> treeSet1 = new TreeSet(new EmployeeComparator());
        for (Employee e : arr) {
            treeSet1.add(e);
        }
        System.out.println(treeSet1.size());

        // 会去重
        treeSet1.add(new Employee(2, 27));
        System.out.println(treeSet1.size());

        System.out.println("====================");
        System.out.println("====================");

        // 如果不想去重，就需要增加更多的比较
        // 比如对象的内存地址、或者如果对象有数组下标之类的独特信息
        // 谁公司编号小，谁在前 、如果公司编号一样,谁年龄小谁在前, 如果都一样,谁对象内存地址小谁在前
        TreeSet<Employee> treeSet2 = new TreeSet<>(
                (a, b) -> a.company != b.company ? (a.company - b.company)
                : a.age != b.age ? (a.age - b.age) : a.toString().compareTo(b.toString()));
        for (Employee e : arr) {
            treeSet2.add(e);
        }
        // 不会去重
        treeSet2.add(new Employee(2, 27));
        System.out.println(treeSet2.size());

    }
}
