package messages;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long id;
    private String text;

    public Message() {
    }

    public Message(long id, String text) {
        this.id = id;
        this.text = text;
    }

//    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
//        System.out.println("In #setId");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
//        System.out.println("In #setText");
    }
}
