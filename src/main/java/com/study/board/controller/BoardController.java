package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/home")
    public ResponseEntity<String> homePage() {
        return ResponseEntity.ok("환영합니다!"); // JSON 응답으로 메시지 반환
    }

    @GetMapping("/write")
    public ResponseEntity<String> WriteForm() {
        return ResponseEntity.ok("글 작성을 위한 폼을 제공합니다.");
    }

    @PostMapping("/writepro")
    public ResponseEntity<String> WritePro(@RequestBody Board board) throws Exception {
        boardService.write(board);
        return ResponseEntity.ok("글 작성이 완료되었습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Board>> List() {
        List<Board> boards = boardService.boardList();
        return ResponseEntity.ok(boards); // JSON 형태로 리스트 반환
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        boardService.boardDelete(id);
        return ResponseEntity.ok("게시글이 삭제되었습니다.");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> Update(@RequestBody Board board) throws Exception {
        Board boardTemp = boardService.boardView(board.getId());
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }
}