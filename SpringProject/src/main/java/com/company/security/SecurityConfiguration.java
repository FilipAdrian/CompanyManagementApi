package com.company.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = passwordEncoder ( );
        auth.inMemoryAuthentication ( ).withUser ("Company").password (encoder.encode ("company")).roles ("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic ( )
                .and ( )
                .authorizeRequests ( )
                .antMatchers (HttpMethod.POST).hasRole ("ADMIN")
                .antMatchers (HttpMethod.PUT).hasRole ("ADMIN")
                .antMatchers (HttpMethod.DELETE).hasRole ("ADMIN")
                .and ( )
                .csrf ( ).disable ( )
                .formLogin ( ).disable ( );

    }

    //
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder ( );
    }
}
