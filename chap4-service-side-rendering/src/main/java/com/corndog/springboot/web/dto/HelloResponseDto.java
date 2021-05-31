package com.corndog.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언 필드의 getter를 생성해 준다. 그냥 코틀린 쓸까보다..
@RequiredArgsConstructor // 선언 필드를 주입받는 생성자를 만든다. final 식별자가 붙은 필드에 한해서!
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
