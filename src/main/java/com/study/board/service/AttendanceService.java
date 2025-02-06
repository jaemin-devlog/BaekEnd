package com.study.board.service;

import com.study.board.entity.Attendance;
import com.study.board.entity.User;
import com.study.board.repository.AttendanceRepository;
import com.study.board.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.userRepository = userRepository;
    }

    // 출석 체크 기능
    public String checkAtd(Long userId) {
        // 사용자 조회
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return "해당 사용자가 존재하지 않습니다.";  // 사용자 없을 경우
        }

        User user = optionalUser.get();

        // 이미 출석한 기록이 있는지 확인
        Optional<Attendance> existingAttendance = attendanceRepository.findByUserIdAndAtdDate(userId, LocalDate.now());
        if (existingAttendance.isPresent()) {
            return "이미 출석이 완료되었습니다.";  // 이미 출석이 된 경우
        }

        // 출석 처리
        try {
            Attendance attendance = new Attendance(user, LocalDate.now(), true);  // 출석 여부 'true'
            attendanceRepository.save(attendance);  // 출석 기록 저장
            return "출석이 완료되었습니다.";  // 출석 성공 메시지
        } catch (Exception e) {
            e.printStackTrace();  // 예외 로그 출력
            return "출석 처리 중 오류가 발생했습니다.";  // 오류 메시지
        }
    }

    // 출석 여부 확인
    public boolean AtdChecked(Long userId) {
        // 사용자가 오늘 출석했는지 확인
        return attendanceRepository.findByUserIdAndAtdDate(userId, LocalDate.now()).isPresent();
    }
}
