package com.klef.jfsd.exam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;

@Service
public class BookService 
{
	@Autowired
	private BookRepository repository; 
	
	
	public String addbook(Book b) 
	{
		repository.save(b);
		return "Book Added Successfully";
	}
	
	
	public String update(Book b) 
	{
		Optional<Book> object = repository.findById(b.getBookId());
		String msg =null;
		
		if(object.isPresent())
		{
			Book b1 = object.get();
			b1.setBookAuthor(b.getBookAuthor());
			b1.setBookGenre(b.getBookGenre());
			b1.setBookPrice(b.getBookPrice());
			b1.setBookTitle(b.getBookTitle());
			b1.setBookYear(b.getBookYear());

			repository.save(b1);
			
			msg="Book Updated Successfully";
		}
		else
		{
			msg = "Book ID Not Found";
		}
		return msg;
	}
}
