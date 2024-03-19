package ru.ergakov.gb.constructiondocapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/login", "/acts").permitAll()
                        .requestMatchers("/public-data", "/act-create").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/acts-admin", "/act-update/**", "/act-delete/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/process_login")
                        .permitAll()
                        .defaultSuccessUrl("/public-data")
                        .failureUrl("/login?error")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/acts")
						.invalidateHttpSession(true)
				)
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    UserDetailsManager inMemoryUserDetailsManager() {
        var user1 = User.withUsername("user").password("{noop}password").roles("USER").build();
        var user2 = User.withUsername("admin").password("{noop}password").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

}
