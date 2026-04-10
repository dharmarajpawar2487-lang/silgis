package com.example.SILGIS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // ❌ CSRF Disable
            .csrf(csrf -> csrf.disable())

            // 🔥 H2 Console frame allow
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            .authorizeHttpRequests(auth -> auth
                // ✅ H2 Console allow
                .requestMatchers("/h2-console/**").permitAll()

                // ✅ Static resources allow
                .requestMatchers(
                        "/assets/**",
                        "/images/**",
                        "/css/**",
                        "/js/**"
                ).permitAll()

                // ✅ बाकी सगळं allow (visitor system)
                .anyRequest().permitAll()
            );

        return http.build();
    }
}