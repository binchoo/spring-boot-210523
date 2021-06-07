package com.corndog.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    // 정말 이렇게 명세를 선언하는 것 만으로, '이메일로 유저 찾기' 기능이 구현된다구??
}
