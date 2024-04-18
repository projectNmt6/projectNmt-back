package com.projectnmt.projectnmt.config;

import com.projectnmt.projectnmt.security.exception.AuthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Autowired
//    private PerminAllfilter perminAllfilter;
//    @Autowired
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthEntryPoint authEntryPoint;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();//WebMvcConfig의 cors 설정을 따라간다.
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**") // 모든 요청에 대해
                .permitAll(); // 인증 없이 허용

    }

}