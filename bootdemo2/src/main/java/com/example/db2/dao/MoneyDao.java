package com.example.db2.dao;

import com.example.bean.Money;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("db2SqlSessionTemplate")
public interface MoneyDao {

    /*
    * 通过id查看工资详情
    * */
    @Select("SELECT * FROM money WHERE id = #{id}")
    Money findMoneyById(@Param("id") int id);

}
