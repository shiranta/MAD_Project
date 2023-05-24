package com.example.myapplication.drivago.models;

public class Question {
    private String id;
    private String question;

    public Question() {
    }

    public Question(String id, String question) {
        this.id = id;
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
