package com.example.db1.service;

import com.example.bean.User;
import com.example.db1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;
  /*
  *  根据名字查找用户
  * */

  public User selectUserByName(String name){
      return userDao.findUserByName(name);
  }
}
