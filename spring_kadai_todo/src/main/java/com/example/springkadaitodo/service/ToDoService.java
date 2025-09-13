package com.example.springkadaitodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

@Service
public class ToDoService {

	 private final ToDoRepository todoRepository;
	 
	 public ToDoService(ToDoRepository todoRepository) {
	        this.todoRepository = todoRepository;
	    }
	 
	 // 新規TODOの登録メソッド
	// ToDoService.java
	 public void createToDo(String todoTitle) {
	     if (todoTitle == null || todoTitle.isEmpty()) {
	         throw new IllegalArgumentException("ToDoを入力してください。");
	     }

	     // 重複チェック（findByTitle を使う）
	     if (!todoRepository.findByTitle(todoTitle).isEmpty()) {
	         throw new IllegalArgumentException("そのToDo名は既に使用されています。");
	     }

	     ToDo todo = new ToDo();
	     todo.setTitle(todoTitle);  // ← title に変更！

	     todoRepository.save(todo);
	 }


	    // TODOの一括取得メソッド
	    public List<ToDo> getAllTodos() {
	        return todoRepository.findAll();
	    }
	 
}


