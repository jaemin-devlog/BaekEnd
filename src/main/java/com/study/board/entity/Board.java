package com.study.board.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // 게시글 ID

    private String title;  // 게시글 제목

    private String content; // 게시글 내용

//    @ManyToOne//Board, Attenance가 User에 속함
//    @JoinColumn(name = "user_id")
//    private User user;  // 작성자 정보 (User와 관계 설정)
}

