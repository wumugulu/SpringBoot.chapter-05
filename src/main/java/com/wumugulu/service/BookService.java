package com.wumugulu.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.wumugulu.entity.Book;
import com.wumugulu.repository.BookRepository;

@Service
public class BookService {
	
	@Resource
	private BookRepository bookRepository;

	// 获取全部
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	// 获取单个
	public Book findOne(Integer id){
		return bookRepository.findOne(id);
	}
	
	//新增
	public Book save(Book book){
		Book tmpBook = bookRepository.findOne(book.getId());
		if (tmpBook!=null) {
			return null;
		}
		
		return bookRepository.save(book);
	}
	
	// 修改
	public Book update(Book book){
		Book tmpBook = bookRepository.findOne(book.getId());
		if (tmpBook==null) {
			return null;
		}
		
		tmpBook.setName(book.getName());
		tmpBook.setAuthor(book.getAuthor());
		tmpBook.setTotalPage(book.getTotalPage());
		tmpBook.setPublishDate(book.getPublishDate());
		
		return bookRepository.save(tmpBook);
	}
	
	// 删除
	public Integer delete(Integer id){
		Book tmpBook = bookRepository.findOne(id);
		if (tmpBook==null) {
			return -1;
		} else{
			bookRepository.delete(id);
			return 0;
		}
	}

}
