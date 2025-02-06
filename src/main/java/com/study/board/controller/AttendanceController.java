package com.study.board.controller;

import com.study.board.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // 출석 여부 확인 API
    @GetMapping("/check/{userId}")
    public ResponseEntity<?> AtdChecked(@PathVariable("userId") Long userId) {
        boolean isChecked = attendanceService.AtdChecked(userId);

        if (isChecked) {
            return ResponseEntity.status(HttpStatus.OK).body("이미 출석을 완료하였습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("출석하지 않았습니다.");
        }
    }

    // 출석 체크 API
    @PostMapping("/check/{userId}")
    public ResponseEntity<?> checkAttendance(@PathVariable("userId") Long userId) {
        try {
            String result = attendanceService.checkAtd(userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);  // 출석 성공 시 201 상태 코드 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("출석 처리 중 오류가 발생했습니다.");  // 에러 발생 시 400 상태 코드
        }
    }
}
