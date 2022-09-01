package git.io.web.config;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@NoArgsConstructor
public class Members {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String userId;
    private String password;
}
