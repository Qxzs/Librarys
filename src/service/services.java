package service;

import org.apache.ibatis.annotations.Param;
import po.book;
import po.lendbook;
import po.pageBean;
import po.users;

import java.util.List;

public interface services {
	public users loginusers(users users);
	public List<book> findbooksByName(String name);//名字查找
	public List<book> findbooksByAuthor(String name);//作者
	public List<book> findbooksByPress(String name);//出版社
	public int insertBook(book book);//添加书
	public int delBook(int id);//删除书
	public int lendBook(lendbook lendbook);//借书
    public int subNum(@Param("book_name")String bookname);//修改可借书本数
	public List<users> checkLend(@Param("id") int id);//查看借书的信息
	public int updateBook(book book);//修改书信息
	public List<book> findAllBook();//查找所有书
	public book findBooksById(@Param("book_id")int i);

	public int selectCount();//总数
	pageBean<book> findByPage(int currentPage,int x);

	public List<users> findAllUsers();//查找所有用户
	public users findUserById(int i);
	public int updateDefine(@Param("id")int id);
    public List<users>findUserByName(@Param("username")String name);
	public int insertUsers(users users);//添加用户
	public int delUsers(int id);//删除用户
	public int updateUsers(users users);//修改用户信息
	public int selectCounts();
	pageBean<users> findByPages(int currentPage,int x);
}
