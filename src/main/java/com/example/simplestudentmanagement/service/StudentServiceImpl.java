package com.example.simplestudentmanagement.service;

import com.example.simplestudentmanagement.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static final Map<Integer, Student> students;

    static {
        students = new HashMap<>();
        students.put(1, new Student("Trần Minh Trí", 99,
                "https://cdn.7tv.app/emote/01F6MA6Y100002B6P5MWZ5D916/3x.webp"));
        students.put(2, new Student("Lê Tuấn Dũng", 99,
                "https://cdn.7tv.app/emote/01F6MXJD8R000F76KNAAV5HDGD/3x.webp"));
        students.put(3, new Student("Nguyễn Đức Thắng", 99,
                "https://cdn.7tv.app/emote/01F9Q9PA100009VDTF4G64R32V/3x.webp"));
        students.put(4, new Student("Phí Hữu Lộc", 99,
                "https://cdn.7tv.app/emote/01F6S7PENR0008HT14D95H43BY/3x.webp"));
        students.put(5, new Student("Đào Văn Huy Hưng", 99,
                "https://cdn.7tv.app/emote/01F6PPENA80002RDNAW6F35V4X/3x.webp"));
    }


    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void add(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(id, student);
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }
}
