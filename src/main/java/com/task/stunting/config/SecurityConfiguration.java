package com.task.stunting.config;

import com.task.stunting.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
    @Bean
    public UserDetailsService userDetailsService(){return new MyUserDetailService();}

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/**").permitAll()
                .mvcMatchers(HttpMethod.POST, "/**").hasAnyAuthority("admin","nuns")
                .mvcMatchers(HttpMethod.PUT, "/**").hasAnyAuthority("admin", "nuns")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
        return http.build();
    }
}
