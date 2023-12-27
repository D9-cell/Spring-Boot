package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    /*Add Support for JDBC .... No more hard core users*/
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //Define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        //Define query to retrieve an authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
        //Use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //Disable Cross Site Request Forgery(CSRF)
        //in general, not required for stateless REST APIs that use POST,PUT,DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }



     /*   @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails provat = User.builder()
                .username("Provat")
                .password("{noop}ProvatItIs")
                .roles("EMPLOYEE")
                .build();

        UserDetails rumpa = User.builder()
                .username("Rumpa")
                .password("{noop}RumpaItIs")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails debangana = User.builder()
                .username("Debangana")
                .password("{noop}DebanganaItIs")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(provat,rumpa,debangana);
    }  */
}

