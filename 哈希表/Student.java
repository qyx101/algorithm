package demo1;

import java.util.Objects;

public class Student {

    public String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        // 根据id 生成哈希值
        return Objects.hashCode(id);
    }
}
