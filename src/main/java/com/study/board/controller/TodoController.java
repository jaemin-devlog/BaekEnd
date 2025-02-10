package com.study.board.controller;

import com.study.board.entity.Todo;
import com.study.board.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // 할 일 목록 조회
    @GetMapping("/list")
    public ResponseEntity<List<Todo>> getTodoList() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos); // 리스트를 반환
    }

    // 할 일 작성
    @PostMapping("/write")
    public ResponseEntity<String> addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        return ResponseEntity.ok("할 일이 추가되었습니다."); // 글 작성 완료 응답
    }

    // 할 일 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Integer id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("삭제되었습니다."); // 삭제 완료 응답
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateTodo(@RequestBody Todo todo)throws Exception {
        Todo todo1 = todoService.TodoView(todo.getId());
        todo1.setTodo(todo.getTodo());
        todo1.setDetail(todo.getDetail());

        todoService.addTodo(todo1);

        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }
}
