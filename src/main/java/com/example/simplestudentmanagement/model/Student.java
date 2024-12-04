package com.example.simplestudentmanagement.model;

public class Student {
    private int id;
    private String name;
    private int score;
    private String photo;
    private int classId;

    public Student() {}

    public Student(String name, int score, String photo, int classId) {
        this.name = name;
        this.score = score;
        this.photo = photo;
        this.classId = classId;
    }

    public Student(int id, String name, int score, String photo, int classId) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.photo = photo;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
