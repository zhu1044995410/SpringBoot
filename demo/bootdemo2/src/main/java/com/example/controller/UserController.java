package com.example.controller;

import com.example.bean.User;
import com.example.db1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* @RestController ：
*    @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
*    返回的内容就是Return 里的内容。
* */
@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserService userService;

   @RequestMapping("/query")
   public User testQuery(){
       return  userService.selectUserByName("Daisy");
   }
}
