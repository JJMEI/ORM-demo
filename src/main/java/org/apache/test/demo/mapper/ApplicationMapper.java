package org.apache.test.demo.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.test.demo.pojo.Application;

import java.util.List;

/**
 *
 * @author meijunjie
 * @date 2019/1/29
 *
 *
 * MyBatis禁止方法重载 MyBatis使用package+Mapper+method全限定key 去寻找xml内寻找唯一sql来执行
 */

public interface ApplicationMapper {



    /**
     * 按ID查询，自动映射
     * @param id
     * @return
     */

    @Select("select * from t_application where id=#{id}")
    // 指定返回类型
    @Results(id="ApplicationResult",value = {
            @Result(column = "application_name", property = "applicationName"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "modify_time",property = "modifyTime")})
    Application selectApplication(Integer id);

    @Select("select * from t_application")
    @ResultMap(value = "ApplicationResult")
    List<Application> selectAll();


    /**
     * 接口默认方法
     */
    default void defaultMethod(){
        System.out.println("我正在执行默认方法");
    }
//
//    @Select("select * from t_application where application_name=#{applicationName}")
//    Application selectApplication(String applicationName);



    @Insert("insert t_application(application_name,owner,create_time,modify_time) values(#{applicationName},#{owner},now(),now())")
    int insertApplication(Application application);
}
