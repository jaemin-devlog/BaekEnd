//package com.study.board.DTO;
//
//
//import lombok.Getter;
//import lombok.Setter;
//
////DTO
////DTO는 Data Transfer Object
////주로 데이터를 전송하기 위한 객체를 의미합니다.
////DTO는 애플리케이션 내에서 계층 간 데이터 전송을 위해 사용
////보통 클라이언트와 서버 간에 데이터를 전달하는 데 사용됩니다.
//public class AttendanceDto {
//
//    // Getter and Setter
//    @Setter
//    @Getter
//    private Long userId;  // 사용자 ID
//    private boolean isPresent;  // 출석 여부
//
//    // 기본 생성자
//    public AttendanceDto() {}
//
//    // 생성자
//    public AttendanceDto(Long userId, boolean isPresent) {
//        this.userId = userId;
//        this.isPresent = isPresent;
//    }
//
//    public boolean isPresent() {
//        return isPresent;
//    }
//
//    public void setPresent(boolean present) {
//        isPresent = present;
//    }
//}
