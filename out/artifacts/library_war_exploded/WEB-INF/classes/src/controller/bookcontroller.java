package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import po.book;
import po.lendbook;
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
public class bookcontroller {
    @Autowired
    private services services;

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
        } else if (cno.equals("1")) {
            books = services.findbooksByAuthor(str);
        } else {
            books = services.findbooksByPress(str);
        }
        if (!books.isEmpty()) {
            session.setAttribute("book", books);
            return "../librarys/usermain.jsp";
        }
        return null;
    }
    @RequestMapping("/searchs")
    @ResponseBody
    public String searchss(String name, String cno, HttpSession session) {
        String str = "";
        List<book> books = null;
        List<users> users = null;
        try {
            str = URLDecoder.decode(name, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (cno.equals("0")) {
            books = services.findbooksByName(str);
        } else{
            users = services.findUserByName(name);
            System.out.println(users);
        }
        if (books!=null) {
            session.setAttribute("book",books);
            session.removeAttribute("listbook");
            return "../librarys/rootmain.jsp";
        }else if (users!=null){
            session.setAttribute("listusers", users);
            session.removeAttribute("listbook");
            session.removeAttribute("book");
            return "../librarys/rootmain.jsp";
        }
        return null;
    }
    @RequestMapping("/findbook")
    @ResponseBody
    public String findbook(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, HttpSession session, HttpServletResponse response,@RequestParam(value = "x", defaultValue = "2", required = false)int x) {
        session.setAttribute("listbook", services.findByPage(currentPage,x));//回显分页数据
        session.removeAttribute("book");
        session.removeAttribute("listuser");
        session.removeAttribute("listusers");
        return "../librarys/rootmain.jsp";
    }

    @RequestMapping("/findbooks")
    @ResponseBody
    public String findbooks(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, HttpSession session, HttpServletResponse response,@RequestParam(value = "x", defaultValue = "2", required = false)int x) {
        session.setAttribute("listbook", services.findByPage(currentPage,x));//回显分页数据
        try {
            response.sendRedirect("../librarys/rootmain.jsp");
        } catch (Exception e) {
            System.out.println(e);
        }
        return "../librarys/rootmain.jsp";
    }

    @RequestMapping("/delBook")
    @ResponseBody
    public String del(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, String id, HttpSession session,@RequestParam(value = "x", defaultValue = "2", required = false)int x) {
        int ids = Integer.valueOf(id);
        int i = services.delBook(ids);
        if (i > 0) {
            session.setAttribute("listbook", services.findByPage(currentPage,x));
            return "../librarys/rootmain.jsp";
        }
        return null;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertBook(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, HttpSession session, HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "x", defaultValue = "2", required = false)int x) {
        String name = request.getParameter("name");
        String face = request.getParameter("face");
        String create = request.getParameter("create");
        String num = request.getParameter("num");
        int num1 = Integer.valueOf(num);
        String author = request.getParameter("author");
        String press = request.getParameter("press");
        String address = request.getParameter("address");
        book book = new book();
        book.setBook_name(name);
        book.setBook_face(face);
        book.setBook_create(create);
        book.setBook_num(num1);
        book.setBook_author(author);
        book.setBook_press(press);
        book.setBook_address(address);

        int i = services.insertBook(book);
        if (i > 0) {
            List<book> books = services.findAllBook();
            session.setAttribute("listbook", services.findByPage(currentPage,x));
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
    public String findID(int id,@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, HttpSession session) {

        book b = services.findBooksById(id);
        if (b != null) {
            session.setAttribute("fBook", b);
        }
        return "../librarys/updateIndex.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updatebook(@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, HttpSession session, HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "x", defaultValue = "2", required = false)int x) {

        String book_id = request.getParameter("book_id");
        int id = Integer.valueOf(book_id);
        String book_name = request.getParameter("book_name");
        String book_face = request.getParameter("book_face");
        String book_create = request.getParameter("book_create");
        String book_num = request.getParameter("book_num");
        int num = Integer.valueOf(book_num);
        String book_author = request.getParameter("book_author");
        String book_address = request.getParameter("book_address");
        book book = new book();
        book.setBook_address(book_address);
        book.setBook_author(book_author);
        book.setBook_num(num);
        book.setBook_create(book_create);
        book.setBook_name(book_name);
        book.setBook_face(book_face);
        book.setBook_id(id);
        int x1 = services.updateBook(book);
        if (x1 > 0) {
            session.setAttribute("listbook", services.findByPage(currentPage,x));
        }
        try {
            response.sendRedirect("../librarys/rootmain.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 借书
     * @param session
     * @param lendbook
     * @return
     */
    @RequestMapping("/lend")
    @ResponseBody
    public String lendbooks(HttpSession session, @RequestBody lendbook lendbook) {
        String bookname = lendbook.getBookname();
        try {
            int i = services.lendBook(lendbook);
            int x = services.subNum(bookname);
            session.removeAttribute("book");
            return "../librarys/usermain.jsp";
        } catch (Exception e) {
            System.out.println(12132);
            return "1";
        }
    }

    /**
     * 借书的情况
     * @param id
     * @param session
     * @param response
     * @param currentPage
     * @return
     */
    @RequestMapping("/checkLend")
    @ResponseBody
    public List<users> check(int id,HttpSession session,HttpServletResponse response,@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage) {
        session.setAttribute("tbbook", services.checkLend(id));//回显分页数据
        session.removeAttribute("book");
        try {

            response.sendRedirect("../librarys/usermain.jsp");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}


