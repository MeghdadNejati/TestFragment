package com.example.paitakht.testfragment.app.MasterDetail.Model;

/**
 * Created by Fakher on 2/6/2017.
 */

public class News {

    private int id;
    private String title;
    private String summary;
    private String content;
    private String[] keywords;

    public News() {
    }

    public News(int id, String title, String summary, String content, String[] keywords) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
