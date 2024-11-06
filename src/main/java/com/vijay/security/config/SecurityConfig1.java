package com.vijay.security.config;

import com.vijay.repository.SignupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig1 {

    private final SignupRepository signupRepository;

    public SecurityConfig1(SignupRepository signupRepository) {
        this.signupRepository = signupRepository;
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
      /*  UserDetails user1 = User.builder().username("deepak").password(passwordEncoder().encode("deepak")).roles("ADMIN").build();
        UserDetails user2 = User.builder().username("thapak").password(passwordEncoder().encode("thapak")).roles("USER").build();

        return new InMemoryUserDetailsManager(user1, user2);*/
        return username ->
                signupRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("invalid credentials"));
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }


}
