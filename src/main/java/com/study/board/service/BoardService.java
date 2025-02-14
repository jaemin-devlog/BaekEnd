package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 게시글 작성
    public void write(Board board) {
        boardRepository.save(board); // 파일 관련 없이 제목과 내용만 저장
    }

    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    public Board boardView(Integer id) {
        Optional<Board> board = boardRepository.findById(id);
        return board.orElse(null); // 해당 ID의 게시글이 없으면 null 반환
    }

    // 게시글 수정
    public void boardUpdate(Board board) {
        boardRepository.save(board); // 기존 게시글 수정 후 저장
    }

    // 게시글 삭제
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id); // 해당 ID의 게시글 삭제
    }
}
