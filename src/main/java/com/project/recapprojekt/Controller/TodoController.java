package com.project.recapprojekt.Controller;

import com.project.recapprojekt.Model.Todo;
import com.project.recapprojekt.Service.TodoService;
import com.project.recapprojekt.dto.TodoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todo")
    public List<Todo> getTodos() {
        return service.getTodos();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable String id) {
        return service.getTodoById(id);
    }

    @PostMapping("/todo")
    public Todo addTodo(@RequestBody TodoDTO todoDTO) {
        return service.addTodo(todoDTO);
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody TodoDTO todoDTO) {
        return service.updateTodo(id, todoDTO);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable String id){
        service.deleteTodo(id);
    }
}
