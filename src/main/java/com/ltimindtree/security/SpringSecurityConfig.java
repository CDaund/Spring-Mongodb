package com.ltimindtree.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import javax.swing.undo.CannotUndoException;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends AbstractSecurityWebApplicationInitializer {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private UserDetailsService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeHttpRequests()
                .requestMatchers("/","/aboutus").permitAll() //dashboard , Aboutus page will be permit to all user
                .requestMatchers("/admin/**").hasAnyRole("ADMIN") //Only admin user can login
                .requestMatchers("/user/**").hasAnyRole("USER") //Only normal user can login
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")    //Loginform all can access ..
                .defaultSuccessUrl("/dashboard")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        return http.build();
    }

    @Autowired
    public void configureGolbal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
}
