package com.task.TaskManagement.controller;


import com.task.TaskManagement.entity.User;
import com.task.TaskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user_Register")
    public String candidate(){
        return "Register";
    }

    @PostMapping("/registration")
    public String createuser(@ModelAttribute User user, HttpSession session){
       boolean f= userService.checkEmail(user.getEmail());
        if (f){
            session.setAttribute("msg","Email Already Exist");
        }else {
            User user1=userService.createUser(user);
            if (user1 != null){
                session.setAttribute("msg","Register Sucessfully");
                }
            else {
               session.setAttribute("msg","Something error in server");
            }
        }
        return "redirect:/user_Register";
    }

    @GetMapping("/Login_user")
    public String LoginUser(){
        return "Login";
    }

    @PostMapping("/login_req")
    public String logindetail(@ModelAttribute User user,HttpSession session){
        User user1 = userService.Login(user.getUsername(),user.getPassword());
        if (user1 != null){
           session.setAttribute("msg","Login Successfully");
        }else {
            session.setAttribute("msg","Invalid Username & Password");
        }
        return ("redirect:/Login_user");
    }

}
