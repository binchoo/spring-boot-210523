package com.corndog.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity; // Entity 클래스임을 명시함
import javax.persistence.GeneratedValue; // PK 생성 규칙을 명시함
import javax.persistence.Id; // PK임을 명시함
import javax.persistence.GenerationType;
import javax.persistence.Column; // 이 필드가 테이블 칼럼이 됨을 명시함

@Getter
@NoArgsConstructor
@Entity
public class Posts { // 실제 DB 테이블과 매칭되는 클래스이다. 이를 Entity 클래스라 한다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id; // PK는 Long + auto-increment 조합을 강추한다.

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 타입을 TEXT로 변경함.
    private String content;

    //Column 선언하지 않은 경우도 칼럼이 된다. 기본값 VARCHAR(255)
    private String author;

    @Builder // 이 생성자를 이용하여 Builder 패턴을 만든다
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    /**
     * Posts.builder().title().content().author().build();
     */
}
