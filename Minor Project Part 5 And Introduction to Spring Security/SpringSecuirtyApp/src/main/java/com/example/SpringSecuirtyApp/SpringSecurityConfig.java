package com.example.SpringSecuirtyApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    //Authentication logic in case of InMemory

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails student = User.builder()
                .username("Rajeev")
                .password(passwordEncoder().encode("rajeev123"))
                .roles("STUDENT")
                .build();

        UserDetails faculty = User.builder()
                .username("Rahul")
                .password(passwordEncoder().encode("rahul123"))
                .roles("FACULTY")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(student,faculty,admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http
                    .authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/student/**").hasRole("STUDENT")
                            .requestMatchers("/faculty/**").hasRole("FACULTY")
                            .requestMatchers("/library/**").hasAnyRole("STUDENT", "FACULTY", "ADMIN")
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .anyRequest().authenticated()
                    )
                    .formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).csrf(csrf -> csrf.disable());


            return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
