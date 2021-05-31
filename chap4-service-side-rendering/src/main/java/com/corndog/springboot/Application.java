package com.corndog.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication // Spring Boot 자동 설정, Bean 읽기 쓰기 자동 설정
public class Application {
    public static void main(String[] args) {
        /**
         * 별도 웹 서버가 필요없는 내장 웹 앱 서버를 실행한다.
         * jar 만으로 웹 앱을 돌릴 수 있기 때문에 환경에 구애 받지 않음. 스프링 부트에서 권장되는 방식임.
         */
        SpringApplication.run(Application.class, args);
    }
}