package com.example.dao;

import com.example.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    /*
    * 通过名字查询
    * */
    /*@Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(@Param("name") String name);*/
    User findUserByName(String name);

    /*
    * 查询所有用户信息
    * */
/*
    @Select("SELECT * FROM user")
    List<User> findAllUser();
*/
    List<User> findAllUser();


    /*
    *  插入用户信息
    * */
   /* @Insert("INSERT INTO user(name,age,money) VALUE(#{name},#{age},#{money})")
    void insertUser(@Param("name") String name,@Param("age") Integer age, @Param("money") Double money);*/

    void insertUser( String name,Integer age,  Double money);



    /*
    * 根据id更新用户信息
    * */
  /*  @Update("UPDATE user SET name = #{name},age = #{age},money = #{money} WHERE id = #{id}")
    void updateUser(@Param("name") String name,@Param("age") Integer age,@Param("money") Double money,
                    @Param("id") int id);*/

    void updateUser(String name, Integer age, Double money, int id);


    /*
    * 根据id删除用户信息
    * */
    /*@Delete("DELETE from user WHERE id = #{id}")
    void  deleteUser(@Param("id") int id);*/
    void  deleteUser( int id);
}
