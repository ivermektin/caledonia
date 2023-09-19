import java.util.Date;

public class data {
    String title;
    String author;
    String content;
    Date date;

    public data(String title, String author,String content){
        this.title = title;
        this.author = author;
        this.content = content;
        date = new Date();
    };
}
