package test;

import mapper.userMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.book;
import po.users;

import java.util.List;

public class test {

public void tests(){
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
	userMapper u = (userMapper) ac.getBean("userMapper");
	users user = new users();
	user.setUsername("kim");
	user.setPwd("123456");
	user.setStatue("1");
	users s =u.loginusers(user);
	System.out.println(s.getPwd());
}
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		userMapper u = (userMapper) ac.getBean("userMapper");
		book book = new book();
	    book.setBook_name("hello");
		//List<book> b =u.findbooks(book.getBook_name());
		System.out.println(book.getBook_name());
	}
	@Test
   public void test2(){//查所有的书
	   ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
	   userMapper u = (userMapper) ac.getBean("userMapper");
	   List<book> bs= u.findAllBook();
	   System.out.print(bs);
   }
   @Test
   public void testInsert(){//插入书本
	   ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
	   userMapper u = (userMapper) ac.getBean("userMapper");
	   book books = new book();
	   books.setBook_name("数学");
	   books.setBook_face("欢迎来学数学");
	   books.setBook_create("2018-4-4");
	   books.setBook_num(6);
	   books.setBook_author("lok");
	   books.setBook_address("一楼");
       int i= u.insertBook(books);
	   System.out.print(i);
	   List<book> sm=u.findAllBook();
	   System.out.print(sm);
   }
   @Test
   public void testDel(){//删除书
	   ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
	   userMapper u = (userMapper) ac.getBean("userMapper");
	   int i = u.delBook(7);
	   if(i==1){
	   	List<book> bs = u.findAllBook();
	   	System.out.print(bs);
	   }else{
	   	System.out.print("error");
	   }
   }
   //更新书本信息
	@Test

	public void test6Update() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		userMapper u = (userMapper) ac.getBean("userMapper");
		book bks = new book();
		bks.setBook_id(6);
		bks.setBook_name("语文");
		bks.setBook_face("欢迎来学语文");
		bks.setBook_create("2018-4-12");
		bks.setBook_num(6);
		bks.setBook_author("loks");
		bks.setBook_address("六楼");
		int i = u.updateBook(bks);
		if(i==1){
			List<book> bs = u.findAllBook();
			System.out.print(bs);
		}else{
			System.out.print("error");
		}
	}
	@Test
	public void te(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		userMapper u = (userMapper) ac.getBean("userMapper");
		book b= u.findBooksById(1);
		System.out.print(b);

	}
}
