package top.jsoft.springsecurity.config;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import top.jsoft.springsecurity.controller.ProductController;
import top.jsoft.springsecurity.enums.RoleType;

/**
 * @author psygrammator
 */
@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        LOGGER.info("Initial...");
        security.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable);

        security.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/ping").hasAnyAuthority(RoleType.ROLE_USER.name())
                .requestMatchers("/product/**").hasAnyAuthority(RoleType.ROLE_ADMIN.name())
                .anyRequest().authenticated()
        );
        security.httpBasic(Customizer.withDefaults());

        return security.build();
    }

}