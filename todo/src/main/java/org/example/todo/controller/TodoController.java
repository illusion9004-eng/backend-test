package org.example.todo.controller;

import lombok.RequiredArgsConstructor;
import org.example.todo.dto.TodoDTO;
import org.example.todo.entity.Todo;
import org.example.todo.repository.TodoRepository;
import org.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 생성자를 자동으로 만들어주는 Lombok
@RequiredArgsConstructor
// Controller (브라우저 > Controller > login.html > 화면)
// RestController (브라우저 > RestController > JSON > {"title": "공부"};
@RestController
// 공통 URL을 지정하는 것
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    //    POST    /todos          등록
    @PostMapping("")
    public Todo creatTodo(@RequestBody TodoDTO todoDTO){
        return todoService.creatdTodo(todoDTO.getTitle(), todoDTO.getContent());
        }
    //    GET     /todos          전체 조회
    @GetMapping("")
    public List<Todo> findAllTodo(){
        return todoService.findAllTodo();
    }

    //    GET     /todos/{id}     단건 조회
    @GetMapping("/{id}")
    public Todo findById(@PathVariable Long id){
        return todoService.getTodo(id);
    }

    //    PUT     /todos/{id}     수정
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO){
        return todoService.updateTodo(
                id,
                todoDTO.getTitle(),
                todoDTO.getContent()
        );
    }

    //    PATCH   /todos/{id}     완료 처리
    @PatchMapping("/{id}")
    public Todo completeTodo(@PathVariable Long id){
        return todoService.completeTodo(id);
    }

    //    DELETE  /todos/{id}     삭제
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        todoService.deleteById(id);
    }

}


//

//

//

