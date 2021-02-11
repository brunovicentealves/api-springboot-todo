package com.bruno.cursoapi.todo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column
	private String description;
	@Column
	private Boolean done;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime createDate;
	@Column
	private LocalDateTime doneDate;
	
	
	// quando persistir no  banco ele ira rodar automaticamente
	//esse comando para inserir a data no campo createDate
	
	@PrePersist
	public void beforeSave() {
		
		setCreateDate(LocalDateTime.now());
		
	}
	

}
