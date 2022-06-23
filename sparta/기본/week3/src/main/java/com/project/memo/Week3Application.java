package com.project.memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 데이터 변동 (Timestamped의 생성, 수정시간 등)이 일어날 경우 JPA가 자동으로 반영하도록 함
@SpringBootApplication
public class Week3Application {

    public static void main(String[] args) {
        SpringApplication.run(Week3Application.class, args);
    }

}
