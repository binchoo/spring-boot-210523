package com.corndog.springboot.web;

import com.corndog.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Rest를 준수하는 콘트롤러를 선언한다
 */
@RestController
public class HelloController {

    @GetMapping("/hello") // acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto hello(@RequestParam("name") String name,
                                  @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}

