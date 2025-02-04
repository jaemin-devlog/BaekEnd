package com.study.board.repository;

import com.study.board.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 사용자 이름이나 이메일로 검색할 수 있는 메서드 추가 가능
    User findByUsername(String username);
    User findByEmail(String email);
}

