package se.lexicon.g51todoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import se.lexicon.g51todoapi.util.CustomPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomPasswordEncoder customPasswordEncoder(PasswordEncoder passwordEncoder) {
        return new CustomPasswordEncoder(passwordEncoder);
    }
}
