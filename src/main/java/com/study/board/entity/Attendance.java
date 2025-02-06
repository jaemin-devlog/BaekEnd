package com.study.board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // 출석한 사용자

    private boolean checked;  // 출석 여부

    private LocalDate atdDate;  // 출석 날짜

    public Attendance(User user, LocalDate atdDate, boolean checked) {
        this.user = user;
        this.atdDate = atdDate;
        this.checked = checked;
    }
}

