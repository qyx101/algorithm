package SeqList;

public interface List<T> {

    // 判断是否为空
    boolean isEmpty();

    // 判断数据个数
    int size();

    // 根据下标获取数据
    T get(int index);

    // 根据下标设置数据
    void set(int index,T val);

    // 设置字符串转化
    String myToString();

    // 尾插
    void add(T val);

    // 指定下标插入
    void add(int index,T val);

    // 根据下标 删除数据
    T remove(int index);

    // 指定数据删除
    T remove(T val);

    // 查找
     int search(T val);

     boolean equals(Object ojb);

}
