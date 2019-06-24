package test;
import mapper.bookMapper;
import mapper.userMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.book;
import po.lendbook;
import po.users;

import java.text.ParseException;
import java.util.List;

public class test {

    @Test
    public void tests(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        userMapper users=(userMapper) ac.getBean("userMapper");
        System.out.println(users.findAllUsers());
}
// 修改
   @Test
   public void test2(){
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    userMapper user=(userMapper) ac.getBean("userMapper");
    users u = new users();
    u.setId(4);
    u.setPwd("11111");
    u.setUsername("b");
    u.setStatue("1");
    int i= user.updateUsers(u);
    if(i>0){
        List<users> uu = user.findAllUsers();
        System.out.println(uu);
    }
 }
 @Test
 public void test3(){
     ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     userMapper user=(userMapper) ac.getBean("userMapper");
     users u = new users();
     u.setPwd("123789");
     u.setUsername("c");
     u.setStatue("1");
     int i= user.insertUsers(u);
     if(i>0){
         List<users> uu = user.findAllUsers();
         System.out.println(uu);
     }
 }

    /**
     * 删除用户
     */
 @Test
 public void test4(){
     ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     userMapper user=(userMapper) ac.getBean("userMapper");
     int i  = user.delUsers(5);
     if (i>0){
         List<users> uu = user.findAllUsers();
         System.out.println(uu);
     }

 }
 @Test
 public void test5(){
     ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     userMapper user=(userMapper) ac.getBean("userMapper");
     users u= user.findUserById(7);
     System.out.println(u);
 }
 @Test
 public void test6(){
     ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     userMapper user=(userMapper) ac.getBean("userMapper");
     users u = new users();
     u.setUsername("huio");
     u.setPwd("123456");
     u.setSex("男");
     u.setClasss("12");
     u.setTel("13164234");
     u.setStatue("1");
     int  i = user.insertUsers(u);
     if (i>0){
         List<users> uu = user.findAllUsers();
         System.out.println(uu);
     }
 }
 @Test
 public void test7(){
     ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     bookMapper user=(bookMapper) ac.getBean("bookMapper");
     List<book> book = user.findbooksByPress("清华");
     System.out.println(book);
 }
 @Test
 public void test8() throws ParseException {
     ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     bookMapper user=(bookMapper) ac.getBean("bookMapper");
     lendbook l = new lendbook();
     l.setUserid(1);
     l.setBookname("jsp程序设计");
     l.setLendtime("2019-04-01");
     l.setBacktime("2019-07-01");
     int i = user.lendBook(l);
     if(i>0){
         System.out.println(123);
    }

 }
 @Test
 public void test9(){
     ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     bookMapper user=(bookMapper) ac.getBean("bookMapper");
     List<users> b = user.checkLend(1);
    for (int i = 0;i<b.size();i++){
        for (int j =0;j<b.get(i).getLendbooks().size();j++)
        System.out.println(b.get(i).getUsername()+b.get(i).getTel()+" "+b.get(i).getClasss()+" "+b.get(i).getLendbooks().get(j));
    }
 }
 @Test
 public void test10(){
     ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
     bookMapper user=(bookMapper) ac.getBean("bookMapper");
     List<book> b=user.findbooksByName("程序");
     System.out.println(b);
 }
    @Test
    public void test11(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        userMapper user=(userMapper) ac.getBean("userMapper");
        List<users> b=user.findUserByName("kim");
        System.out.println(b);
    }
    @Test
    public void test12(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        userMapper user=(userMapper) ac.getBean("userMapper");
       int b=user.updateDefine(13);
        if (b>0){
            System.out.println(123);
        }
    }
//successly update
}
