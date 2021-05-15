package pl.sda.spring.securitytraining.entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.sda.spring.securitytraining.user.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class Entry {

    private Integer id;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    private LocalDateTime creationDate;
}
