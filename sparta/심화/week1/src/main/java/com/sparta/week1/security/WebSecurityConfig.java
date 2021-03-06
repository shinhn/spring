package com.sparta.week1.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests()

                // image 폴더를 login 없이 허용
                .antMatchers("/images/**").permitAll()
                // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()

                // 회원 관리 URL 전부를 login 없이 허용
                .antMatchers("/user/**").permitAll()

                // h2-console URL 을 login 없이 허용
                .antMatchers("/h2-console/**").permitAll()

                // 그 외 모든 요청은 인증과정 필요
                // 어느 요청이 오던지 로그인 요청이 없으면 로그인 과정 수행
                .anyRequest().authenticated()
                .and()
                .formLogin()

                // 로그인 페이지 설정
                .loginPage("/user/login")
                // 로그인 실패했을때 페이지 설정
                .failureUrl("/user/login/error")

                // 로그인이 완료 되었을 때 위치 ("/" -> home을 의미)
                .defaultSuccessUrl("/")
                // 로그인 페이지에 대해서는(formLogin()) 허용 (permitAll() )
                .permitAll()
                .and()
                // 로그아웃 페이지 허용
                .logout()
                .permitAll();
    }
}
