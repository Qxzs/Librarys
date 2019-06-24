package mapper;

import org.apache.ibatis.annotations.Param;
import po.book;
import po.lendbook;
import po.users;

import java.util.HashMap;
import java.util.List;

public interface bookMapper {
 public users loginusers(users users);//用户登录

 public List<book> findbooksByName(String name);//通过书名找书
 public List<book> findbooksByAuthor(String name);//通过作者找书
 public List<book> findbooksByPress(String name);//通过出版社找书


 public int insertBook(book book);//添加书
 public int lendBook(lendbook lendbook);//借书
 public int subNum(@Param("book_name")String bookname);
 public List<users> checkLend(@Param("id") int id);
 public int delBook(int id);//删除书
 public int updateBook(book book);//修改书信息
 public List<book> findAllBook();//查找所有书
 public book findBooksById(@Param("book_id") int i);
//分页
 public int selectCount();//查数据总数
 List<book> findByPage(HashMap<String,Object> map);
}
