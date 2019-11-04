package messages;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
//    @Id
    private long id;
    private String text;

    public Message() {
    }

    public Message(long id, String text) {
        this.id = id;
        this.text = text;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        System.out.println("In #setId");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        System.out.println("In #setText");
    }
}
