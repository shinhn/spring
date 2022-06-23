package com.sparta.week1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 시간 자동 변경이 가능하도록 함
public class Week1Application {

    public static void main(String[] args) {
        SpringApplication.run(Week1Application.class, args);
    }

}
