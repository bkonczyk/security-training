package pl.sda.spring.securitytraining.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/entries")
@RequiredArgsConstructor
public class EntryController {

    private final EntryService service;

    @PostMapping
    public void create(@RequestBody CreateEntryRequest request, Principal principal) {
        service.createEntry(request, principal.getName());
    }
}
