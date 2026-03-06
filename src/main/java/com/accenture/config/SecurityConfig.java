package com.accenture.config;

import com.accenture.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static com.accenture.Role.CLIENT;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)

public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()

                        .requestMatchers(HttpMethod.POST, "/clients/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/clients/{id}").hasAnyAuthority("ADMINISTRATOR", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/clients/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.DELETE, "/clients/**").hasAnyAuthority("ADMINISTRATOR", "CLIENT")

                        .requestMatchers(HttpMethod.GET, "/administrator/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.DELETE, "/administrator/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.PUT, "/administrator/**").hasAuthority("ADMINISTRATOR")

                        .requestMatchers(HttpMethod.GET, "/bikes/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/bikes/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.PUT, "/bikes/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.PATCH, "/bikes/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.POST, "/bikes/**").hasAuthority("ADMINISTRATOR")

                        .requestMatchers(HttpMethod.GET, "/cars/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/cars/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.PUT, "/cars/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.PATCH, "/cars/**").hasAuthority("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.POST, "/cars/**").hasAuthority("ADMINISTRATOR")
                        .anyRequest().authenticated()


                );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select email, password, 1 from client where email = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select email, case role when 0 then 'CLIENT' when 1 then 'ADMINISTRATOR' end as authority from client where email = ?");
        return jdbcUserDetailsManager;
    }



}
