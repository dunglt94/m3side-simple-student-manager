package com.example.simplestudentmanagement.model;

public class Student {
    private static int count = 0;
    private int id;
    private String name;
    private int score;
    private String photo;

    public Student() {}

    public Student(String name, int score, String photo) {
        this.id = ++count;
        this.name = name;
        this.score = score;
        this.photo = photo;
    }

    public Student(int id, String name, int score, String photo) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.photo = photo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
}
