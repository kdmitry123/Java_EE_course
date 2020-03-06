import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "author")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Author implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne
    public Book book;

    public Author(String name, Book book) {
        this.name = name;
        this.book = book;
    }
}
