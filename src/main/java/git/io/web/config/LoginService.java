package git.io.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.builder;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Members element = repository.findByUserId(username)
                .orElseThrow(() -> new IllegalArgumentException("NOT FOUND"));

        return builder()
                .username(element.getUserId())
                .password(element.getPassword())
                .roles("USER")
                .build();
    }
}