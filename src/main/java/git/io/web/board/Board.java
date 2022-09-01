package git.io.web.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String title;
    private String content;
    private String author;

    @CreatedBy
    private LocalDateTime createAt;

    private Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createAt = now();
    }

    public static Board of(String title, String content, String author) {
        return new Board(title, content, author);
    }
}
