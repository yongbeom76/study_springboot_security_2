package com.study.study_springboot_security_2.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@Configuration
public class SecurityConfiguration {
  @Bean // return 한 object를 spring이 관리하겠다는 얘기
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    // url & roles : user url & roles 비교해준다.
    httpSecurity.authorizeRequests()
        // .antMatchers("/").authenticated() // 로그인 여부만 판단.
        // .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/admin").authenticated()
        .anyRequest().permitAll(); // 설정한 url이외는 접근 가능

    // 로그인에 대한 부분
    httpSecurity.formLogin().loginPage("/loginForm")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/");

    return httpSecurity.build();
  }
}
