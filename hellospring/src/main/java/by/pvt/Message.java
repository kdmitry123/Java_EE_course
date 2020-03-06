package by.pvt;

import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable {

    private final static long serialVersionUID = 1L;

    private Long id;

    private String subject;

    private String body;

    private String to;

    private String from;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (subject != null ? !subject.equals(message.subject) : message.subject != null) return false;
        if (body != null ? !body.equals(message.body) : message.body != null) return false;
        if (to != null ? !to.equals(message.to) : message.to != null) return false;
        return from != null ? from.equals(message.from) : message.from == null;
    }

//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (subject != null ? subject.hashCode() : 0);
//        result = 31 * result + (body != null ? body.hashCode() : 0);
//        result = 31 * result + (to != null ? to.hashCode() : 0);
//        result = 31 * result + (from != null ? from.hashCode() : 0);
//        return result;
//    }
}
