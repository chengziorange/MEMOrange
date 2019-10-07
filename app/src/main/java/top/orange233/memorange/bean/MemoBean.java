package top.orange233.memorange.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class MemoBean extends LitePalSupport {

    private int number = -1;

    @Column(defaultValue = "无标题")
    private String title;

    private String date;

    private String content;

    public MemoBean() {
    }

    public MemoBean(int number, String title, String date, String content) {
        this.number = number;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
