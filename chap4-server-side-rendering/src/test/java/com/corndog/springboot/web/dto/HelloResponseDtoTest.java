package com.corndog.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat; //저자가 권장하는 검증 라이브러리

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        final String name = "binchoo";
        final int amount = 1000;

        // when
        HelloResponseDto data = new HelloResponseDto(name, amount);

        // then
        assertThat(data.getName()).isEqualTo(name);
        assertThat(data.getAmount()).isEqualTo(amount);
    }
}