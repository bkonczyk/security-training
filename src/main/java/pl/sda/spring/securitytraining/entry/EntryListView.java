package pl.sda.spring.securitytraining.entry;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class EntryListView {

    private String author;
    private String contents;
    private LocalDateTime creationTimestamp;
}
