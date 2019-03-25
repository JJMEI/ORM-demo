package org.apache.test.demo;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.test.demo.mapper.ApplicationMapper;
import org.apache.test.demo.pojo.Application;
import org.apache.test.demo.util.DbUtil;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by meijunjie on 2019/1/29.
 */
public class MybatisDemo {

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = DbUtil.getSqlSession();


    try {
        System.out.println(sqlSession.toString());

        System.out.println("---------------------------------------------------------------------");


        ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);

        List<Application> applicationList = applicationMapper.selectAll();
        applicationList.forEach(System.out::println);

        System.out.println(applicationMapper.selectApplication(1).toString());




        System.out.println("执行接口默认方法---------------------");
        applicationMapper.defaultMethod();

        applicationMapper.insertApplication(Application.builder().applicationName("APP1").owner("Mike1").build());
        sqlSession.commit();

    }catch (Exception e){
            e.printStackTrace();
        }finally {
        sqlSession.close();
        }
    }
}
