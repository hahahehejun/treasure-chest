package com.github.hahahehejun;

import com.github.hahahehejun.model.School;
import com.github.hahahehejun.model.Student;
import com.github.hahahehejun.util.ProtostuffUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wu
 * @date 2021/12/30 15:08
 */
public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student("张三",20);
        Student stu2 = new Student("李四",21);
        List<Student> students = new ArrayList<Student>();
        students.add(stu1);
        students.add(stu2);
        School school = new School("西工大",students);
        //首先是序列化
        byte[] bytes = ProtostuffUtils.serialize(school);
        System.out.println("序列化后: " + bytes);
        //然后是反序列化
        School group1 = ProtostuffUtils.deserialize(bytes,School.class);
        System.out.println("反序列化后: " + group1.toString());
    }
}