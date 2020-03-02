package com.meng.controller;

import com.meng.pojo.User;
import com.meng.pojo.UserRole;
import com.meng.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session
    ){
        User user = userService.queryUserByUsername(username);

        if (username !="" && user.getPassword().equals(password)){
            //具体业务
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";

        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "redirect:/login";
        }



    }
}
