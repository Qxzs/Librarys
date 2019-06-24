package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.users;
import service.services;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;


@Controller
public class userlogin {
    /**
     * 实现用户登录验证
     */
    @Autowired
    private services services;

    @RequestMapping("/logins")
    @ResponseBody
    public int login(users users,String verifiCode, HttpSession session, HttpServletRequest request) {
        users u = services.loginusers(users);
        String sessionVerifyCode = (String) session.getAttribute("verifyCodeValue");
        String str = sessionVerifyCode.toLowerCase();//验证码大小写转换，无论大小写
        verifiCode = verifiCode.toLowerCase();//验证码大小写转换，无论大小写
        if (!verifiCode.equals(str)){
            return 3;
        }
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

    @RequestMapping("/outs")
    @ResponseBody
    public String toOut(HttpSession session, HttpServletResponse response) {
        session.invalidate();
        try {
            response.sendRedirect("../librarys/login.jsp");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /* 获取校验码 */
    @RequestMapping("/getVerifyCode")
    @ResponseBody
    public void generate(HttpServletResponse response, HttpSession session) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String verifyCodeValue = drawImg(output);
        session.setAttribute("verifyCodeValue", verifyCodeValue);
        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 绘画验证码
     *
     * @param output
     * @return
     */
    private String drawImg(ByteArrayOutputStream output) {
        String code = "";
        // 随机产生4个字符
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        // 调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66, 2, 82);
        g.setColor(color);
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Random r = new Random();
        for(int i=0;i<20;i++){

            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));;
            //画圆
            g.fillOval(r.nextInt(75),r.nextInt(30),5,5);
        }
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return code;
    }

    /**
     * 随机参数一个字符
     *
     * @return
     */
    private char randomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
}
