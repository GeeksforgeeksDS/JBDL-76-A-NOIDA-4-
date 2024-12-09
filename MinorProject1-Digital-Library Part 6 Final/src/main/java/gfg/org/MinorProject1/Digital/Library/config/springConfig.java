package gfg.org.MinorProject1.Digital.Library.config;


import gfg.org.MinorProject1.Digital.Library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class springConfig {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(studentService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authority -> authority
                        .requestMatchers("/student/create").permitAll()
                        .requestMatchers("/student/get/{studentId}").hasAnyAuthority("STUDENT", "ADMIN")
                        .requestMatchers("/student/update/{id}").hasAnyAuthority("ADMIN", "STUDENT")
                        .requestMatchers("/student/getAll").hasAuthority("ADMIN")
                        .requestMatchers("/book/**").hasAuthority("ADMIN")
                        .requestMatchers("/txn/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())

                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();

    }




}
