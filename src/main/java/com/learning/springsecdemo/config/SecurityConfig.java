package com.learning.springsecdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> configurer) {
                configurer.disable();

            }
        };

        http.csrf(custCsrf);
        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
            @Override
            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
                registry.anyRequest().authenticated();
            }
        };
        http.authorizeHttpRequests(custHttp);

        Customizer<FormLoginConfigurer<HttpSecurity>> custForm = new Customizer<FormLoginConfigurer<HttpSecurity>>() {
            @Override
            public void customize(FormLoginConfigurer<HttpSecurity> configurer) {
                configurer.loginPage("/login");
            }
        };
        http.formLogin(custForm);

        Customizer<HttpBasicConfigurer<HttpSecurity>> custHttpBasic = new Customizer<HttpBasicConfigurer<HttpSecurity>>() {
            @Override
            public void customize(HttpBasicConfigurer<HttpSecurity> configurer) {
                configurer.disable();
            }
        };
        http.httpBasic(custHttpBasic);

        Customizer<SessionManagementConfigurer<HttpSecurity>> custSession = new Customizer<SessionManagementConfigurer<HttpSecurity>>() {
            @Override
            public void customize(SessionManagementConfigurer<HttpSecurity> configurer) {
                configurer.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
            }
        };
        http.sessionManagement(custSession);


//        http.csrf(customizer -> customizer.disable());
//        http.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();

        }

    }
