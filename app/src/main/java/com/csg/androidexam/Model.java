package com.csg.androidexam;

public class Model {
    private String url;
    private String title;
    private String content;

    public Model(String url, String title, String content) {
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }


}
