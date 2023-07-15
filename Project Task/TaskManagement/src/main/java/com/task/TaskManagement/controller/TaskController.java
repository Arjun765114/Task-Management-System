package com.task.TaskManagement.controller;


import com.task.TaskManagement.entity.Task;
import com.task.TaskManagement.service.TaskService;
import com.task.TaskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/task_user")
    public String task(){
        return "Task";
    }

    @GetMapping("/task_Register")
    public String taskRegister(){
        return "CreateTask";
    }

    @PostMapping("/done")
    public String createTask(@ModelAttribute Task task, HttpSession session){
         boolean r = userService.checkId(task.getUser_id());
         if (r){
             Task task1= taskService.SaveTask(task);
             if (task1 != null){
                 session.setAttribute("msg","Task Register Successfully");
             }
             else {
                 session.setAttribute("msg","Something Went Wrong");
             }
         }else {
             session.setAttribute("msg"," Id Not Exist!!");
         }
       return "redirect:/task_Register";
    }

    public List<Task> getAll(){
       return taskService.getAllTask();
    }


}
