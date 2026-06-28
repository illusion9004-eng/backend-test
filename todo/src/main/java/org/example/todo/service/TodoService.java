package org.example.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todo.entity.Todo;
import org.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // 등록 = 새 객체 만들고 save
    // 조회 = findAll/findById
    // 수정 = findById로 찾고 값 바꾸기
    // 저장(완료) = findById로 찾고 completed = true
    // 삭제 = existsById 확인 후 deletedById

    // 1. Todo 등록
    //- 제목, 내용으로 Todo 생성
    //- completed는 처음엔 false
    //- createdAt은 현재 시간
    // 등록 = Todo 반환 / title, content 받기 / save()
    public Todo creatdTodo(String title, String content){
        Todo todo = Todo.builder()
                .title(title)
                .content(content)
                .completed(false)
                .createdAt(LocalDateTime.now())
                .build();
        return todoRepository.save(todo);
    }

    //2. Todo 전체 조회
    //- Repository에서 전체 Todo 가져오기
    //전체조회 = List<Todo> 반환 / 아무것도 안 받기 / findAll()
    public List<Todo> findAllTodo(){
        return todoRepository.findAll();

    }

    //3. Todo 단건 조회
    //- id로 Todo 찾기
    //- 없으면 예외 처리
    //단건조회 = Todo 반환 / id 받기 / findById()
    public Todo getTodo(Long id){
        return todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo를 찾을 수 없습니다."));
    }

    //4. Todo 수정
    //- id로 기존 Todo 찾기
    //- title, content 수정
    //- 없으면 예외 처리
    // 수정 = Todo 반환 / id,title,content 받기 / findById 후 값 변경
    public Todo updateTodo(Long id, String title, String content){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo를 찾을 수 없습니다."));
        todo.setTitle(title);
        todo.setContent(content);

    return todoRepository.save(todo);

    }

    //5. Todo 완료 처리
    //- id로 기존 Todo 찾기
    //- completed를 true로 변경
    public Todo completeTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo를 찾을 수 없습니다."));

        todo.setCompleted(true);

        return todoRepository.save(todo);
    }

    //6. Todo 삭제
    //- id가 존재하는지 확인
    //- 있으면 삭제
    //- 없으면 예외 처리
    // 삭제 = void 반환 / id 받기 / deleteById()
    public void deleteById(Long id){
        if (!todoRepository.existsById(id)){
            throw new IllegalArgumentException("Todo를 찾을 수 없습니다.");
        }
        todoRepository.deleteById(id);
    }
}
