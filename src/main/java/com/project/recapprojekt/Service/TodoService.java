package com.project.recapprojekt.Service;

import com.project.recapprojekt.Model.Todo;
import com.project.recapprojekt.Repository.TodoRepo;
import com.project.recapprojekt.dto.TodoDTO;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TodoService {

    private final TodoRepo todoRepo;
    private final IdService idService;

    public TodoService(TodoRepo todoRepo, IdService idService) {
        this.todoRepo = todoRepo;
        this.idService = idService;
    }

    public List<Todo> getTodos() {
        return todoRepo.findAll();
    }

    public Todo getTodoById(String id) {
        return todoRepo.findById(id).orElseThrow(() -> new RuntimeException("Todo with id " + id + " not found"));
    }

    public Todo addTodo(TodoDTO todoDTO) {

        String randomId = idService.randomId();

        Todo todo = new Todo(
                randomId,
                todoDTO.getDescription(),
                todoDTO.getStatus()
        );
        return todoRepo.save(todo);
    }

    public Todo updateTodo(String id,TodoDTO todoDTO) {
        return todoRepo.findById(id)
                .map(existing -> {
                    existing.setDescription(todoDTO.getDescription());
                    existing.setStatus(todoDTO.getStatus());
                    return todoRepo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Todo with id " + id + " not found"));
    }

    public void deleteTodo(String id){
        todoRepo.findById(id).orElseThrow(() -> new RuntimeException("Todo with id " + id + " not found"));
        todoRepo.deleteById(id);
    }
}
