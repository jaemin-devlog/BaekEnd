package com.study.board.service;

import com.study.board.entity.Todo;
import com.study.board.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // 할 일 추가
    public void addTodo(Todo todo) {
        todoRepository.save(todo);  // Todo 엔티티를 데이터베이스에 저장
    }

    // 할 일 목록 조회
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();  // 데이터베이스에서 모든 Todo를 조회
    }


    // 게시글 상세 조회
    public Todo TodoView(Integer id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.orElse(null); // 해당 ID의 게시글이 없으면 null 반환
    }

    // 할 일 수정
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);  // 수정된 Todo 객체를 데이터베이스에 저장
    }

    // 할 일 삭제
    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);  // 해당 ID의 Todo 삭제
    }
}

