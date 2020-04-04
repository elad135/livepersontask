package com.liveperson.intents.task.common;

public class IntentRecord {
    private int id;
    private String category;
    private String subCategory;
    private String text;

    public IntentRecord(String category, String subCategory, String text) {
        this.category = category;
        this.subCategory = subCategory;
        this.text = text;
    }

    public IntentRecord(int id, String category, String subCategory, String text) {
        this.id = id;
        this.category = category;
        this.subCategory = subCategory;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
