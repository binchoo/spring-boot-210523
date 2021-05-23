package com.corndog.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // JUnit 내장 테스트 실행자 대신, Spring 테스트 실행자를 사용한다.
@WebMvcTest(controllers = HelloController.class) // 테스트 성격을 명시한다. Spring MVC 테스트.
public class HelloControllerTest {

    @Autowired // 스프링 빈을 주입한다
    private MockMvc mvc; // Mvc 테스트의 시작점, 웹 API 테스트를 제공하는 목 클래스.

    @Test
    public void hello가_리턴된다() throws Exception {
        final String hello = "hello";
        mvc.perform(get("/hello")) // 목 GET 리퀘스트 빌더를 주입한다. 곧 목 mvc가 리퀘스트를 수행하여 ResultActions을 반환한다.
                .andExpect(status().isOk()) // StatusResultMatcher를 생성하고 isOk에 대한 ResultMatcher를 생성한다.
                .andExpect(content().string(hello)); // ContentResultMatcher를 생성하고 string에 대한 ResultMatcher를 생성한다.
    }
}