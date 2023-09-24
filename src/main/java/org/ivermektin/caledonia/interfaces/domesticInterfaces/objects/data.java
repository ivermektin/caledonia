package org.ivermektin.caledonia.interfaces.domesticInterfaces.objects;

import java.util.Date;

/**
 * This object class is data.
 * This is a class representing a piece of data.
 * It contains information about the title, author, content, and date of the data.
 */

public class data {
    String title;
    String author;
    String content;
    String date;

    /**
     * Constructs a new data object with the given title, author, and content.
     * The date is automatically set to the current date and time.
     * @param title the title of the data
     * @param author the author of the data
     * @param content the content of the data
     */
    public data(String title, String author, String content){
        this.title = title;
        this.author = author;
        this.content = content;
        date = new Date().toString();
    };

    /**
     * Retrieves the title of the data.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the author of the data.
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the content of the data.
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Retrieves the date of the data.
     * @return the date
     */
    public String getDate() {
        return date;
    }
}