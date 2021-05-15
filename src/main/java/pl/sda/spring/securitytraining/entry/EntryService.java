package pl.sda.spring.securitytraining.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.spring.securitytraining.user.User;
import pl.sda.spring.securitytraining.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntryService {

    private final EntryRepository repository;
    private final UserService userService;

    public void createEntry(CreateEntryRequest request, String username) {
        User author = userService.findByUsername(username);
        Entry entry = new Entry(request.getContents(), author);
        repository.save(entry);
    }

    public List<EntryListView> getAllEntries() {
        List<Entry> entries = repository.findAll();
        return entries.stream()
            .map(this::mapToListView)
            .collect(Collectors.toList());
    }

    private EntryListView mapToListView(Entry entry) {
        return new EntryListView()
            .setAuthor(entry.getAuthor().getUsername())
            .setContents(entry.getContents())
            .setCreationTimestamp(entry.getCreationDate());
    }
}
