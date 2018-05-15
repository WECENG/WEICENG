package cn.gdou.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component("message")
public class Message {
    private Date date;
    private String content;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
