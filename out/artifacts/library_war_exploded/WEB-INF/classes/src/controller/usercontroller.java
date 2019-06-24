package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import po.pageBean;
import po.users;
import service.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class usercontroller {
    @Autowired
    private services services;

    @RequestMapping("/finduser")
    @ResponseBody
    public String find(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, HttpSession session, HttpServletResponse response,@RequestParam(value = "x", defaultValue = "2", required = false)int x){
        pageBean<users> P = services.findByPages(currentPage,x);
        session.setAttribute("listuser",P);
        session.removeAttribute("listbook");
        return "../librarys/rootmain.jsp";

    }

    @RequestMapping("/findusers")
    @ResponseBody
    public String  findusers(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, HttpSession session,HttpServletResponse response,String flag,@RequestParam(value = "x", defaultValue = "2", required = false)int x){
        session.setAttribute("listuser",services.findByPages(currentPage,x));//回显分页数据
            try {
                response.sendRedirect("../librarys/rootmain.jsp");
            } catch (Exception e) {
                System.out.println(e);
        }

        return null;
    }
    // 注册
    @RequestMapping(value = "/inseruser")
    @ResponseBody
 public String insert(users u, HttpServletResponse response, HttpServletRequest request, HttpSession session, @RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,@RequestParam(value = "x", defaultValue = "2", required = false)int x){
        System.out.println(u);
        int i = services.insertUsers(u);
        if (i>0){
            session.setAttribute("reflag","1");
            session.setAttribute("listuser",services.findByPages(currentPage,x));
        }
        try {
            response.sendRedirect("../librarys/login.jsp");
        }catch(Exception e){
            System.out.println(e);
        }
        return null ;
 }
 @RequestMapping("/updateuser")
    @ResponseBody
    public String updateuser(int id ,HttpSession session){
        users u = services.findUserById(id);
        if (u!=null){
            session.setAttribute("fuser",u);
        }
        return "../librarys/show.jsp";
    }
    @RequestMapping("/updateusers")
    @ResponseBody
    public String updateusers(int id ,HttpSession session,HttpServletResponse response){
        users u = services.findUserById(id);
        if (u!=null){
            session.setAttribute("fuser",u);
        }
        try {
           response.sendRedirect("../librarys/show.jsp");
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @RequestMapping("/updateuserss")
    @ResponseBody
    public String updateuserss(int id ,HttpSession session,HttpServletResponse response,@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,@RequestParam(value = "x", defaultValue = "2", required = false)int x){
        int i = services.updateDefine(id);
        if(i>0) {
            session.setAttribute("listuser",services.findByPages(currentPage,x));
            return "../librarys/rootmain.jsp";
        }
        return null;
    }
 @RequestMapping("/updateu")
    @ResponseBody
    public String updates(HttpSession session,HttpServletRequest request,HttpServletResponse response,users users){
//     String user_id = request.getParameter("id");
//     int id = Integer.valueOf(user_id);
//     String username = request.getParameter("username");
//     String pwd = request.getParameter("pwd");
//     String statue = request.getParameter("statue");
//     users u = new users();
//     u.setPwd(pwd);
//     u.setUsername(username);
//     u.setStatue(statue);
//     u.setId(id);
     System.out.println(users);
     int x = services.updateUsers(users);
     if(x>0){
         session.setAttribute("user",services.findUserById(users.getId()));
     }
     try {
         response.sendRedirect("../librarys/usermain.jsp");
     } catch (IOException e) {
         e.printStackTrace();
     }
        return null;
 }
 @RequestMapping("/deluser")
 @ResponseBody
 public String del(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,int id, HttpSession session,@RequestParam(value = "x", defaultValue = "2", required = false)int x){
     int i = services.delUsers(id);
     if (i > 0) {
         session.setAttribute("listuser",services.findByPages(currentPage,x));
         return "../librarys/rootmain.jsp";
     }
        return null;
 }
}
