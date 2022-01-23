package com.example.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookstore.datamodel.Book;
import com.example.bookstore.repository.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> findBooks(){
		return bookRepo.findAll();
	}
	
	public Optional<Book> fetchBook(int id){
		return bookRepo.findById(id);
	}
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
	public boolean deleteBook(int id) {
		boolean status;
		try {
			bookRepo.deleteById(id);
			status=true;
		}catch (Exception e) {
			status=false;}
		
		return status;
		}
	
	public List<Book> searcholdestAndLatest(){
		List<Book> asclist =bookRepo.findAll(Sort.by(Sort.Direction.ASC, "year"));
		
		List<Book> newList = new ArrayList<Book>() ;
		try {
		newList.add(asclist.get(0));
		newList.add(asclist.get(asclist.size()-1));
		}catch (Exception e) {}
		return newList;
	}
}

