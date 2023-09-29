package org.ivermektin.caledonia.services.internalServices.objects;

import java.util.Date;

public class Data {
    String title;
    String author;
    String content;
    String date;

    /**
     * The date is automatically set to the current date and time.
     */
    public Data(String title, String author, String content){
        this.title = title;
        this.author = author;
        this.content = content;
        date = new Date().toString();
    };

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}
