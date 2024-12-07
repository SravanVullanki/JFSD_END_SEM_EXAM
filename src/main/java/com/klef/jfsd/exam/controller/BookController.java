package com.klef.jfsd.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.service.BookService;

@RestController
@RequestMapping("book")
public class BookController 
{
	@Autowired
	private BookService service;
	
	@PostMapping("/add")
	public String add(@RequestBody Book b)
	{
		return service.addbook(b);
	}
	
	@PutMapping("update")
	public String updatestudent(@RequestBody Book b)
	{
		return service.update(b);
	}
}
