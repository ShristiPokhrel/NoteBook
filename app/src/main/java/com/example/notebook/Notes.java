package com.example.notebook;

public class Notes {

    String title;
    String dis;
    String category;

    public Notes(String title, String dis, String category) {
        this.title = title;
        this.dis = dis;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
