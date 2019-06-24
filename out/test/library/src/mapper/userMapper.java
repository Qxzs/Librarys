package mapper;

import org.apache.ibatis.annotations.Param;
import po.book;
import po.users;

import java.util.List;

public interface userMapper {
 public users loginusers(users users);//用户登录

 public List<book> findbooksByName(String name);//通过书名找书
 public List<book> findbooksByAuthor(String name);//通过作者找书




 public users insertUsers(users users);//添加用户
 public String delUsers(int id);//删除用户
 public users updateUsers(users users);//修改用户信息
 public List<users> findAllUsers();//查找所有用户

 public int insertBook(book book);//添加书
 public int delBook(int id);//删除书
 public int updateBook(book book);//修改书信息
 public List<book> findAllBook();//查找所有书
 public book findBooksById(@Param("book_id")int i);
}
