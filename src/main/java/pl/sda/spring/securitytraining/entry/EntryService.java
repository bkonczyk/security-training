package pl.sda.spring.securitytraining.entry;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.spring.securitytraining.user.User;
import pl.sda.spring.securitytraining.user.UserService;

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
}
