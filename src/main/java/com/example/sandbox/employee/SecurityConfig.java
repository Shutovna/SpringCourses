package com.example.sandbox.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user1 = User.builder()
                .username("Vasya")
                .password("{noop}password")
                .roles("EMPLOYEE")
                .build();
        UserDetails user2 = User.builder()
                .username("Masha")
                .password("{noop}password")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails user3 = User.builder()
                    .username("Nikitos")
                .password("{noop}password")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> {
            configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
        });

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
