package controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.book;
import po.users;
import service.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;


@Controller
public class userlogin {
	/**
	 * 实现用户登录验证
	 */
	@Autowired
	private services services;

	@RequestMapping("/logins")
	@ResponseBody
	public int login(users users, HttpSession session) {
		System.out.println(users);
		users u = services.loginusers(users);
		if (u != null) {
			session.setAttribute("user", u);
			System.out.println("验证成功");
			if (u.getStatue().equals("1")) {
				return 1;
			} else if (u.getStatue().equals("0")) {
				return 2;
			}
		}
		return 0;
	}

	@RequestMapping("/search")
	@ResponseBody
	public String searchs(String name, String cno, HttpSession session) {
		String str = "";

		List<book> books = null;
		try {
			str = URLDecoder.decode(name, "utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (cno.equals("0")) {
			books = services.findbooksByName(str);
		} else {
			books = services.findbooksByAuthor(str);
		}
		System.out.println(books);
		if (!books.isEmpty()) {

			session.setAttribute("book", books);
			return "../librarys/usermain.jsp";
		}
		return null;


	}


	@RequestMapping("/findbook")
	@ResponseBody
	public String findaAllBooks(String type, HttpSession session) {
		List<book> books = null;
		if (type.equals("book")) {
			books = services.findAllBook();
		}
		if (!books.isEmpty()) {
			session.setAttribute("listbook", books);
			System.out.print(books);
			return "../librarys/rootmain.jsp";
		}
		return null;
	}

	@RequestMapping("/delBook")
	@ResponseBody
	public String del(String id, HttpSession session) {
		int ids = Integer.valueOf(id);
		int i = services.delBook(ids);
		if (i > 0) {
			List<book> books = services.findAllBook();
			session.setAttribute("listbook", books);
			return "../librarys/rootmain.jsp";
		}
		return null;
	}

	@RequestMapping("/insert")
	@ResponseBody
	public String insertBook(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String face = request.getParameter("face");
		String create = request.getParameter("create");
		String num = request.getParameter("num");
		int num1 = Integer.valueOf(num);
		String author = request.getParameter("author");
		String address = request.getParameter("address");
		book book = new book();
		book.setBook_name(name);
		book.setBook_face(face);
		book.setBook_create(create);
		book.setBook_num(num1);
		book.setBook_author(author);
		book.setBook_address(address);
		//System.out.print(book);
		int i = services.insertBook(book);
		if (i > 0) {
			List<book> books = services.findAllBook();
			System.out.print(books);
			session.setAttribute("listbook", books);
		}
		try {
			response.sendRedirect("../librarys/rootmain.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


  @RequestMapping("/updateBooks")
  @ResponseBody
	public String findID(@Param("book_id")int id, HttpSession session){
		System.out.print(123);
		book b = services.findBooksById(1);
		System.out.print(b);
		return "rootmain";
  }
	}

