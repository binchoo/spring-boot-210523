package com.corndog.springboot.config.auth.dto;

import com.corndog.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

// 인증된 사용자의 정보를 표상한다. 직렬화 기능을 갖고 있다.
// httpSession에서 사용하기 위해 직렬화가 필요하다.
// User는 Entity니까 직렬화시켜 다른 엔티티에 부수효과를 주는 행위를 삼가야 한다.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
