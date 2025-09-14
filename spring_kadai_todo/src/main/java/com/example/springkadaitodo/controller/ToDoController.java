package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // 一覧表示（GET）
    @GetMapping("/todo")
    public String showToDoList(Model model) {
        List<ToDo> todos = toDoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todoView";
    }

}

