package SeqList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SeqList<T> implements List<T>, java.lang.Iterable<T> {

    // 成员变量
    protected Object[] element;
    protected int usedSize;

    // 构造方法
    public SeqList(int length) {
        this.element = new Object[length];
    }

    public SeqList() {
        this(512);
    }

    public SeqList(T[] array) {
        this(array.length);
        for (int i = 0; i < array.length; i++) {
            this.element[i] = array[i];
        }
        this.usedSize = element.length;
    }


    // 判断 数组是否为空
    @Override
    public boolean isEmpty() {
        return 0 == this.usedSize;
    }

    //  获取 数据个数
    @Override
    public int size() {
        return this.usedSize;
    }

    // 根据下标 获取数据
    @Override
    public T get(int index) {
        return (T) this.element[index];
    }

    // 根据下标 修改数据
    @Override
    public void set(int index, T val) {
        this.element[index] = val;
    }


    @Override
    public String myToString() {
        String str = "[";
        for (int i = 0; i < this.usedSize; i++) {
            str += this.element[i];
            if (i < usedSize - 1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }

    // 尾插
    @Override
    public void add(T val) {
        this.element[this.usedSize++] = val;
    }

    // 指定下标插入
    @Override
    public void add(int index, T val) {
        // 1,2,3,4,5
        // [2] 插入下标2
        // 1,2, ,3,4,5
        // 0,1,2,3,4,5 下标
        for (int i = this.usedSize - 1; i >= index; i--) {
            this.element[i + 1] = this.element[i];
        }
        this.element[index] = val;
        this.usedSize++;
    }

    // 根据下标 删除数据
    @Override
    public T remove(int index) {
        T ret = (T) this.element[index];
        for (int i = index; i < usedSize - 1; i++) {
            this.element[i] = this.element[i + 1];
        }
        this.usedSize--;
        return ret;
    }

    @Override
    public T remove(T val) {
        // 找到删除元素下标
        int index = this.search(val);
        T ret = this.remove(index);
        return ret;
    }

    // 查找数据, 返回下标
    @Override
    public int search(T val) {
        for (int i = 0; i < element.length; i++) {
            if (element[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new SeqIterator();
    }

    private class SeqIterator implements java.util.Iterator<T> {
        int index = -1;
        int succ = 0;

        public boolean hasNext() {
            return this.succ < SeqList.this.usedSize;
        }

        public T next() {
            T value = SeqList.this.get(this.succ);
            if (value != null) {
                this.index = this.succ++;
                return value;
            }
            throw new java.util.NoSuchElementException();
        }

        public  void remove() {
            if (this.index >=0 && this.index<SeqList.this.usedSize) {
                SeqList.this.remove(this.index);

                if(this.succ>0) {
                    this.succ--;
                }
                this.index=-1;
            }else {
                throw new  java.util.ConcurrentModificationException();
            }
        }

    }
}
