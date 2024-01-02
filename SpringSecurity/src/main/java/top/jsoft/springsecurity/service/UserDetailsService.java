package top.jsoft.springsecurity.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.jsoft.springsecurity.config.SecurityConfiguration;
import top.jsoft.springsecurity.model.UserDetails;
import top.jsoft.springsecurity.repository.UserRepository;

/**
 * @author psygrammator
 */
@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsService.class);
    private final UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetails(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " is absent")));
    }
}