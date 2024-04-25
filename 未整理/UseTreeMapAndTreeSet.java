package demo;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapAndTreeSet {

    // TreeSet 使用
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(4);

        // 4 - set 默认去重, 只会留一个key
        //System.out.println(set.size());

        set.add(1);
        set.add(2);
        while (!set.isEmpty()) {
            // 从大到小, 弹出数据
            // 4 3 2 1
            //System.out.println(set.pollLast());

            // 从小到大, 弹出数据
            // 1 2 3 4
            System.out.println(set.pollFirst());


        }
    }

    // TreeMap 使用
    // 下面的操作, HashMap、HashSet 做不到
    public static void main2(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(5,"这是5");
        treeMap.put(1,"这是1");
        treeMap.put(7,"这是7");
        treeMap.put(9,"这是9");
        treeMap.put(4,"这是4");
        treeMap.put(3,"这是3");

        // 1, 最小的key
        System.out.println(treeMap.firstKey());

        // 9, 最大的key
        System.out.println(treeMap.lastKey());

        // 找 <= 4 的key, 没有4就找离4最近的
        // 4
        System.out.println(treeMap.floorKey(4));
        treeMap.remove(4);
        // 3
        System.out.println(treeMap.floorKey(4));

    }
    public static void main1(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(5,"这是5");
        treeMap.put(1,"这是1");
        treeMap.put(7,"这是7");
        treeMap.put(9,"这是9");

        // true
        System.out.println(treeMap.containsKey(5));
        // false
        System.out.println(treeMap.containsKey(10));
        // "这是5"
        System.out.println(treeMap.get(5));

        // "这是7"
        System.out.println(treeMap.containsKey(7));
        treeMap.remove(7);
        // true
        System.out.println(treeMap.get(7) == null);


    }

}
