package com.example.petproject.configs;

//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.Collections;

//@EnableWebSecurity
//@RequiredArgsConstructor
//@Configuration
//public class WebSecurityConfig {
//    private final AuthenticationTokenFilter authenticationTokenFilter;
//    private final JwtUserDetailsServiceImpl jwtUserDetailsServiceImpl;
//    private final AuthenticationEntryPointHandler authenticationEntryPointHandler;

//    @SneakyThrows
//    @Bean
//    public AuthenticationManager authenticationManagerBean(HttpSecurity http) {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(jwtUserDetailsServiceImpl).passwordEncoder(passwordEncoder());
//
//        return authenticationManagerBuilder.build();
//    }
//
//    @SneakyThrows
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) {
//        http.securityMatcher("/services/**")
//                .authorizeHttpRequests(auth -> auth.requestMatchers(
//                                "/services/v3/registration/**",
//                                "/services/v3/registration/unblock/**",
//                        .permitAll()
//                )
//                .logout(logoutConfigurer -> {
//                    logoutConfigurer.invalidateHttpSession(Boolean.TRUE);
//                    logoutConfigurer.logoutUrl("/logout");
//                });
//        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.csrf(AbstractHttpConfigurer::disable);
////        http.cors(AbstractHttpConfigurer::disable);
//        http.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()));
//        http.addFilterBefore(authenticationTokenFilter, BasicAuthenticationFilter.class);
//        http.exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(authenticationEntryPointHandler));
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        var configuration = new CorsConfiguration();
//        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE"));
//        configuration.setAllowedHeaders(Arrays.asList("X-Backside-Transport", "Content-Type", "Authorization",
//                "X-Requested-With", "Content-Length", "Accept", "Origin", "Location", "Accept-Language"));
//        configuration.setExposedHeaders(Arrays.asList("X-Backside-Transport", "Content-Type", "Authorization",
//                "X-Requested-With", "Content-Length", "Accept", "Origin", "Location", "Accept-Language"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}