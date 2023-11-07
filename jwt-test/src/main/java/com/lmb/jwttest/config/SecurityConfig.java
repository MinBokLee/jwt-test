package com.lmb.jwttest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

//Web 보안 활성화
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return  web -> web.ignoring()
                          .antMatchers(
                  "h2-console/**"
                            ,"/favicon.ico"
                            ,"/error"
                            );
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
            .antMatchers("/api/health-check").permitAll()
            .anyRequest().authenticated();
        return http.build();
    }

}
