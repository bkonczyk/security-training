package pl.sda.spring.securitytraining.entry;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUpdateEntryRequest {

    private String contents;
}
