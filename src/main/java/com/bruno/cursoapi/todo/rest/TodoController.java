package com.bruno.cursoapi.todo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bruno.cursoapi.todo.model.Todo;
import com.bruno.cursoapi.todo.repository.TodoRepositor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {
	
	@Autowired
	private TodoRepositor repository;
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
	
		return repository.save(todo);
		
	}

	@GetMapping
	public List<Todo> getAll(){
		return (List<Todo>) repository.findAll();
	}

	//https not found 404
	@GetMapping("/{id}")
	public Todo  getById(@PathVariable Long id ) {                                                  
		return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("{id}")
	public  void delete(@PathVariable Long id ){
	repository.deleteById(id);
	}

	@PatchMapping("{id}/done")
	public Todo markAsDone(@PathVariable Long id){
	return repository.findById(id).map( todo -> {
		todo.setDone(true);
		todo.setDoneDate(LocalDateTime.now());
		repository.save(todo);
		return todo;
	}).orElse(null);
	}

}
