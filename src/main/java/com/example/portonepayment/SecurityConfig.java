package com.example.portonepayment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/signUp", "/all/**").permitAll()
                        .requestMatchers("/templates/admin/**").hasRole("templates/admin")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/signIn").permitAll()
                        .defaultSuccessUrl("/merchandise/list")
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/signOut"))
                        .logoutSuccessUrl("/signIn")
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
