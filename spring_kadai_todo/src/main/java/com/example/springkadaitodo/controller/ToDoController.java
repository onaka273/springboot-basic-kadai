package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // 一覧表示（GET）
    @GetMapping("/")
    public String showToDoList(Model model) {
        List<ToDo> todos = toDoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todoView";
    }

    // 登録処理（POST）
    @PostMapping("/")
    public String addToDo(@RequestParam String todoTitle, RedirectAttributes redirectAttributes) {
        try {
            toDoService.createToDo(todoTitle);
            redirectAttributes.addFlashAttribute("successMessage", "登録しました！");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("failureMessage", e.getMessage());
        }
        return "redirect:/"; // 登録後はトップページにリダイレクト
    }
}

