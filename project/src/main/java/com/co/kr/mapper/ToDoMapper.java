package com.co.kr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.ToDoDTO;

@Mapper
public interface ToDoMapper {
	public List<ToDoDTO> selectToDoList();
	public int insertToDoList(ToDoDTO params);
	public int updateToDoList(ToDoDTO params);
	public int deleteToDoList(Long idx);
	

}
