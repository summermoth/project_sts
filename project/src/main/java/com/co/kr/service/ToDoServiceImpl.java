package com.co.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.domain.ToDoDTO;
import com.co.kr.mapper.ToDoMapper;

@Service
public class ToDoServiceImpl implements ToDoService{
	
	@Autowired
	private ToDoMapper toDoMapper;

	@Override
	public List<ToDoDTO> getToDoList() {
		// TODO Auto-generated method stub
		List<ToDoDTO> todoList = toDoMapper.selectToDoList();
		return todoList;
	}

	@Override
	public boolean inserToDoList(ToDoDTO params) {
		// TODO Auto-generated method stub
		int queryResult =0;
		if(params != null)
			queryResult = toDoMapper.insertToDoList(params);
			
		return (queryResult == 1)?true:false;
	}

	@Override
	public boolean updateToDoList(ToDoDTO params) {
		// TODO Auto-generated method stub
		int queryResult = 0;
		if(params != null)
			queryResult = toDoMapper.updateToDoList(params);
		return (queryResult == 1)?true:false;
	}

	@Override
	public boolean deleteToDoList(Long id) {
		// TODO Auto-generated method stub
		int queryResult = 0;
		if(id != null)
			queryResult = toDoMapper.deleteToDoList(id);
		return (queryResult == 1)?true:false;
	}

	

}
