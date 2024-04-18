class MyCircularDeque {

    public int[] deque;
    public int l,r,size,limit;

    public MyCircularDeque(int k) {
        deque = new int[k];
        limit = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }else {
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            }else {
                l = (l == 0) ? (limit - 1) : (l - 1);
                deque[l] = value;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }else {
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            }else {
                r = r == (limit - 1) ? 0 : (r + 1);
                deque[r] = value;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }else {
            l = (l == limit - 1) ? 0 : (l + 1);
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }else {
            r = (r == 0) ? (limit - 1) : (r - 1);
            size--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }else {
            return deque[l];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }else {
            return deque[r];
        }
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public boolean isFull() {
        return size == limit;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */