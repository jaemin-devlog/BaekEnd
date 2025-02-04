package com.study.board.service;
import com.study.board.entity.Attendance;
import com.study.board.entity.User;
import com.study.board.repository.AttendanceRepository;
import com.study.board.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;  // 사용자 정보를 확인할 UserRepository

    public AttendanceService(AttendanceRepository attendanceRepository, UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.userRepository = userRepository;
    }

    // 출석 체크
    public String checkAtd(Long userId) {
        LocalDate today = LocalDate.now();

        // 사용자 확인
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // 이미 출석했는지 확인
        Attendance existingAttendance = attendanceRepository.findByUserIdAndAtdDate(userId, today);

        if (existingAttendance != null) {
            return "이미 출석이 완료되었습니다.";
        }

        // 새로운 출석 객체 생성
        Attendance attendance = new Attendance(user, today, true);

        // 출석 저장
        attendanceRepository.save(attendance);
        return "출석이 완료되었습니다.";
    }

    // 출석 여부 확인
    public boolean AtdChecked(Long userId) {
        LocalDate today = LocalDate.now();
        return attendanceRepository.findByUserIdAndAtdDate(userId, today) != null;
    }
}
