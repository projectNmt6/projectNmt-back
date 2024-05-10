package com.projectnmt.projectnmt.config;

import com.projectnmt.projectnmt.security.exception.AuthEntryPoint;
import com.projectnmt.projectnmt.security.filter.JwtAuthenticationFilter;
import com.projectnmt.projectnmt.security.filter.PerminAllfilter;
import com.projectnmt.projectnmt.security.handler.OAuth2SuccessHandler;
import com.projectnmt.projectnmt.service.OAuth2PrincipalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private PerminAllfilter perminAllfilter;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthEntryPoint authEntryPoint;
    @Autowired
    private OAuth2SuccessHandler oAuth2SuccessHandler;
    @Autowired
    private OAuth2PrincipalUserService oAuth2PrincipalUserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();//WebMvcConfig의 cors 설정을 따라간다.
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/main/**","/tag/**", "/auth/**", "/comment/**", "/challenge/**", "/challengeComment/get/**", "/like/get", "/donator")
                .permitAll()
                .antMatchers("/tag/donationtag")
                .permitAll()
                .antMatchers("/main/write")
                .not().permitAll()
                .antMatchers("/mail/authenticate")
                .permitAll()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/main/write")
                .hasRole("TEAM")
                .antMatchers("/main/write")
                .not().hasRole("BANNED_USER")
                .anyRequest()
                .authenticated()
                .and()
                .addFilterAfter(perminAllfilter, LogoutFilter.class)
                .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .oauth2Login()
                .successHandler(oAuth2SuccessHandler)
                .userInfoEndpoint()
                .userService(oAuth2PrincipalUserService);
    }
}