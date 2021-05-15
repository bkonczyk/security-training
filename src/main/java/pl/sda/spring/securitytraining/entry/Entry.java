package pl.sda.spring.securitytraining.entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pl.sda.spring.securitytraining.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "entries")
@Data
@NoArgsConstructor
public class Entry {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @CreationTimestamp
    private LocalDateTime creationDate;

    public Entry(String contents, User author) {
        this.contents = contents;
        this.author = author;
    }
}
