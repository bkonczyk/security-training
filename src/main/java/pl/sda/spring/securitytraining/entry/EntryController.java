package pl.sda.spring.securitytraining.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/entries")
@RequiredArgsConstructor
public class EntryController {

    private final EntryService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody CreateUpdateEntryRequest request, Principal principal) {
        service.createEntry(request, principal.getName());
    }

    @GetMapping
    public Page<EntryListView> getAllEntries(@PageableDefault(size = 5) Pageable pageable) {
        return service.getPage(pageable);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateEntry(@PathVariable Long id, @RequestBody CreateUpdateEntryRequest request) {
        service.update(id, request);
    }
}
