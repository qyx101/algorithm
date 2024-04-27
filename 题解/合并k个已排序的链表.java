import java.util.*;

// 合并k个已排序的链表
// 知识点: 堆, 比较器
// https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6

public class Solution {

    // 牛客提交时, 不要提交这个类
     static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    // 谁val小,谁优先级高
    static class Cmp implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists (ArrayList<ListNode> arr) {

         // 小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Cmp());

        // k条链表
        // 每一个链表的头节点入堆
        // O(K * logK)
        for (ListNode cur : arr) {
            if (cur != null) {
                heap.add(cur);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }

        // N * (logK)
        ListNode head = null,tail = null;
        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            if (head == null) {
                head = tail = top;
            }else {
                tail.next = top;
                tail = tail.next;
            }

            //
            if (top.next != null) {
                heap.add(top.next);
            }
        }
        return head;
    }
}