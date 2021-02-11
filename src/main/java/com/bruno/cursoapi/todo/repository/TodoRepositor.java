package com.bruno.cursoapi.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bruno.cursoapi.todo.model.Todo;

@Repository
public interface TodoRepositor  extends CrudRepository<Todo,Long>{

	
}
