package com.sparta.week1.prac;

public class Course {
    private String title;
    private String tutor;
    private int days;

    public Course() {
        this.title = "title";
        this.tutor = "tutor";
        this.days = 0;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void setDays(int day) {
        this.days = day;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTutor() {
        return this.tutor;
    }

    public int getDays() {
        return this.days;
    }
}
