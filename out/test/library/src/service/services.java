package service;

import po.book;
import po.users;

import java.util.List;

public interface services {
	public users loginusers(users users);
	public List<book> findbooksByName(String name);
	public List<book> findbooksByAuthor(String name);

	public int insertBook(book book);//添加书
	public int delBook(int id);//删除书
	public int updateBook(book book);//修改书信息
	public List<book> findAllBook();//查找所有书
	public book findBooksById(int i);
}
