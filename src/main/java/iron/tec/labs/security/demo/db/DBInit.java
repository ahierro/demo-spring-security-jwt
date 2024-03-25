package iron.tec.labs.security.demo.db;

import iron.tec.labs.security.demo.model.User;
import iron.tec.labs.security.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static iron.tec.labs.security.demo.model.Role.ADMIN;

@Service
@AllArgsConstructor
public class DBInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        userRepository.save(User.builder()
                .name("admin")
                .password(passwordEncoder.encode("admin"))
                .role(ADMIN)
                .build());
    }
}
