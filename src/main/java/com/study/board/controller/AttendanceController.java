package com.study.board.controller;
import com.study.board.entity.User;
import com.study.board.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // 출석 체크 API
    @PostMapping("/check/{userId}")
    public String checkAttendance(@PathVariable Long userId) {
        return attendanceService.checkAtd(userId);
    }

    // 출석 여부 확인 API
    @GetMapping("/checked/{userId}")
    public boolean isAttendanceChecked(@PathVariable Long userId) {
        return attendanceService.AtdChecked(userId);
    }
}
