import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "book")
@Getter
@Setter
@EqualsAndHashCode
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }
}
