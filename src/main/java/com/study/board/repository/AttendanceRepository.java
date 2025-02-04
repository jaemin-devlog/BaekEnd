package com.study.board.repository;

import com.study.board.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // 필요한 커스텀 메서드 추가 가능
    Attendance findByUserIdAndAtdDate(Long userId, LocalDate atdDate);
}
