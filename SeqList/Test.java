package SeqList;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        /*SeqList<Integer> seqList = new SeqList<Integer>();
        seqList.add(1);
        seqList.add(2);
        seqList.add(3);
        seqList.add(4);
        seqList.add(5);
        seqList.remove(7);
        System.out.println(seqList.myToString());*/

        // 迭代器遍历原理
        String[] str = {"a","b","c","d","e"};
        SeqList<String> seqList = new SeqList<String>(str);
        Iterator<String> it = seqList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
