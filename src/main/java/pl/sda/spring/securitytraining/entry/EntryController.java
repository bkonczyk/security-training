package pl.sda.spring.securitytraining.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/entries")
@RequiredArgsConstructor
public class EntryController {

    private final EntryService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody CreateEntryRequest request, Principal principal) {
        service.createEntry(request, principal.getName());
    }

    @GetMapping
    public Page<EntryListView> getAllEntries(@PageableDefault(size = 5) Pageable pageable) {
        return service.getPage(pageable);
    }
    // 1. Endpoint @GetMapping zwracający wszystkie istniejące wpisy
    // 2. Chcę widzieć username authora, contents i creationDate
    // Nowy DTO: EntryListView
    // Nowy endpoint w controllerze
    // w serwisie zmapować Entry na nowy DTO i zwrócić przez controller
}
