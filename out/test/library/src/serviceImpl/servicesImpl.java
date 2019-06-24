package serviceImpl;

import mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import po.book;
import po.users;
import service.services;

import java.util.List;

public class servicesImpl implements services{
    @Autowired
	private userMapper userMapper;
	private int i;

	public users loginusers(users users) {
		
		return this.userMapper.loginusers(users);
	}
	@Override
	public List<book> findbooksByName(String name) {
		// TODO Auto-generated method stub
		return this.userMapper.findbooksByName(name);
	}
	@Override
	public List<book> findbooksByAuthor(String name) {
		
		return this.userMapper.findbooksByAuthor(name);
	}

	@Override
	//插入书本信息
	public int insertBook(book book) {

		return this.userMapper.insertBook(book);
	}

	@Override
	//删除书本
	public int delBook(int id) {

		return this.userMapper.delBook(id);
	}

	@Override
	//更新书本信息
	public int updateBook(book book) {
		return this.userMapper.updateBook(book);
	}

	@Override
	//查所有的书
	public List<book> findAllBook() {

		return this.userMapper.findAllBook();
	}

	@Override
	public book findBooksById(int i) {

		return null;
	}


}
