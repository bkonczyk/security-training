package pl.sda.spring.securitytraining.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sda.spring.securitytraining.user.User;
import pl.sda.spring.securitytraining.user.UserService;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class EntryService {

    private final EntryRepository repository;
    private final UserService userService;

    public void createEntry(CreateUpdateEntryRequest request, String username) {
        User author = userService.findByUsername(username);
        Entry entry = new Entry(request.getContents(), author);
        repository.save(entry);
    }

    public Page<EntryListView> getPage(Pageable pageable) {
        return repository
            .findAll(pageable)
            .map(this::mapToListView);
    }

//    public List<EntryListView> getAllEntries() {
//        List<Entry> entries = repository.findAll();
//        return entries.stream()
//            .map(this::mapToListView)
//            .collect(Collectors.toList());
//    }

    private EntryListView mapToListView(Entry entry) {
        return new EntryListView()
            .setAuthor(entry.getAuthor().getUsername())
            .setContents(entry.getContents())
            .setCreationTimestamp(entry.getCreationDate());
    }

    public void update(Long id, CreateUpdateEntryRequest request) {
        Entry entry = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entry not found"));
        entry.setContents(request.getContents());
        repository.save(entry);
    }
}
