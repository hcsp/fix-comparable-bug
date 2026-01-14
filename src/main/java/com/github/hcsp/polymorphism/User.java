package com.github.hcsp.polymorphism;

import java.util.*;

public class User implements Comparable<User> {
    /** 用户ID，数据库主键，全局唯一 */
    private final Integer id;

    /** 用户名 */
    private final String name;

    public User(Integer id, String name) {      // 构造器
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User person = (User) o;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /** 老板说让我按照用户名排序 */
    @Override
    public int compareTo(User o) {
        int nameCompare = name.compareTo(o.getName());
        if (nameCompare != 0) {
            return nameCompare;          // name 不同：按 name 排序
        }
        return id.compareTo(o.getId());  // name 相同：按 id 排序（避免被当作重复）
    }

    public static void main(String[] args) {
        List<User> users =
                Arrays.asList(
                        new User(100, "b"),
                        new User(10, "z"),
                        new User(1, "a"),
                        new User(2000, "a"));

        TreeSet<User> treeSet = new TreeSet<>(users);
        System.out.println(treeSet.size());
    }
}
