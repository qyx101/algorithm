package demo1;

public class HashBuck2 <K,V> {

    public static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Object[] array = new Object[10];
    public int usedSize;

    public void push(K key,V val) {

        // 1. 计算对象的哈希值, 找到下标位置
        int index = key.hashCode() % array.length;
        Node<K,V> cur = (Node<K,V>) array[index];

        // 2. 遍历链表
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }

        // 头插
        Node<K,V> node = new Node<>(key,val);
        node.next = (Node<K,V>) array[index];
        array[index] = node;
        usedSize++;

    }
}
