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

}

