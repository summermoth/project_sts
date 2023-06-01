package com.co.kr.service;

import java.util.List;

import com.co.kr.domain.ToDoDTO;

public interface ToDoService {
	public List<ToDoDTO> getToDoList();
	public boolean inserToDoList(ToDoDTO params);
	public boolean updateToDoList(ToDoDTO params);
	public boolean deleteToDoList(Long id);

}
