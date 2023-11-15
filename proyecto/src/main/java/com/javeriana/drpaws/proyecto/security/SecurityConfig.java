package com.javeriana.drpaws.proyecto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /*
         * Se recomienda desactivar CSRF cuando se la comunicación se están manejando
         * páginas web
         * donde la comunicación entre la página y el servidor es mediante peticiones
         * HTTP
         */
        http
                .csrf(AbstractHttpConfigurer::disable)
                /* H2 */
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .authorizeHttpRequests(requests -> requests
                        /* H2 */
                        .requestMatchers("/h2/**").permitAll()
                        // AUTENTICACION
                        .requestMatchers("/autenticacion/**").permitAll()
                        // USUARIOS
                        .requestMatchers("/usuario/find/**").hasAuthority("USUARIO")
                        .requestMatchers("/mascota/find/**").hasAuthority("USUARIO")
                        // VETERINARIOS Y ADMIN
                        .requestMatchers("/mascota/**").hasAnyAuthority("VETERINARIO","ADMINISTRADOR")
                        .requestMatchers("/tratamientos/**").hasAnyAuthority("VETERINARIO","ADMINISTRADOR")
                        .requestMatchers("/medicamentos/**").hasAnyAuthority("VETERINARIO","ADMINISTRADOR")
                        .requestMatchers("/usuario/**").hasAnyAuthority("VETERINARIO","ADMINISTRADOR")
                        .requestMatchers("/veterinario/**").hasAuthority("ADMINISTRADOR")
                        .requestMatchers("/admin/**").hasAuthority("ADMINISTRADOR")                    
                        // TODAS LAS PAGINAS
                        .anyRequest().permitAll()


                )
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint))
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager (
        AuthenticationConfiguration authenticationConfiguration
    ) throws Exception{

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter(){
        return new JWTAuthenticationFilter();
    }




}
