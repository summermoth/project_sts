package com.co.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.kr.domain.ToDoDTO;
import com.co.kr.service.ToDoService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@GetMapping(value = "/")
	public String todoList(Model model) {
		List<ToDoDTO> toDoList = toDoService.getToDoList();
		toDoList.forEach(S -> System.out.println(S));
		System.out.println("todo");
		model.addAttribute("toDoList", toDoList);
		model.addAttribute("todo", new ToDoDTO());
		return "index";		
	}
	//할일 등록으로 맵핑(단일 페이지의 프로젝트로 return은 redirect:/으로 줌)
	@PostMapping(value = "/todo/select.do")
    public String insertToDoList(Model model, ToDoDTO params){
		
        toDoService.inserToDoList(params);
        return "redirect:/";
    }

    @PostMapping(value = "/todo/update.do")
    public String updateToDoList(@RequestParam(value = "id", required = false) Long id, ToDoDTO params){
        System.out.print("check");
        System.out.println(id);
        toDoService.updateToDoList(params);
        return "redirect:/";
    }

    @PostMapping(value="/todo/delete.do")
    public String deleteToDoList(@RequestParam(value="id", required = false) Long id){
        System.out.println("삭제"+id);
        toDoService.deleteToDoList(id);
        return "redirect:/";
    }

}
