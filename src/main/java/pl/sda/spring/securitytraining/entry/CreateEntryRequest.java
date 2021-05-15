package pl.sda.spring.securitytraining.entry;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEntryRequest {

    private String contents;
}
