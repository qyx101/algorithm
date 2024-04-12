package demo1;

public class HashBuck {

    public static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array = new Node[10];
    public int usedSize;

    public void push(int key,int val) {
        // 1. 根据key找到对应索引
        int index = key % array.length;

        // 2. 遍历
        // 如果key相同, 更新val
        Node cur = array[index];
        Node node = new Node(key,val);

        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }

        // 3. 头插
        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        // 4. 检查 负载因子 >= 0.75
        // 如果 >= 0.75, 进行重新哈希
        if (doLoadFactor() >= 0.75) {
            // 进行重新哈希
            reSize();
        }
    }

    private void reSize() {
        Node[] newArray = new Node[array.length*2];
        for (int i = 0;i < array.length;i++) {
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;
                Node curNext = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;
    }

    private double doLoadFactor() {
        return this.usedSize * 1.0 / array.length;
    }

    public int get(int key) {
        // 1. 定位索引
        int index = key % array.length;
        Node cur = array[index];

        // 2. 遍历链表查找
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }


}
