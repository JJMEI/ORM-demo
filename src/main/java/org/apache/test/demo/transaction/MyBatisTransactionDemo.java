package org.apache.test.demo.transaction;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.test.demo.mapper.ApplicationMapper;
import org.apache.test.demo.pojo.Application;
import org.apache.test.demo.util.DbUtil;

/**
 *
 * @author meijunjie
 * @date 2019/1/31
 *
 *
 * autoCommit=true表示自动提交事务，背后代表自动开启、自动提交事务。
 * autoCommit=false时，事务自动开启，意思是说不需要begin transaction，也没有begin transaction这样的接口，
 * autoCommit=false就表示事务自动开启，但需要手动提交。
 */
public class MyBatisTransactionDemo {

    public static void main(String[] args) {
        // 事务隔离级别  B可以读A的未提交事务
        SqlSession sqlSession = DbUtil.getSqlSessionFactory().openSession(TransactionIsolationLevel.READ_UNCOMMITTED);
        try{
            System.out.println("可以读未提交数据.....");
            ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);
            applicationMapper.insertApplication(Application.builder().applicationName("App2").owner("Jack1").build());
            // no commit
            System.out.println(applicationMapper.selectAll());


            System.out.println("只能读取到已提交的数据...");
            sqlSession = DbUtil.getSqlSessionFactory().openSession(TransactionIsolationLevel.READ_COMMITTED);
            applicationMapper.insertApplication(Application.builder().applicationName("App3").owner("Jack3").build());
            System.out.println(applicationMapper.selectAll());


        }catch (Exception e){
        }finally {
            // only close
            sqlSession.close();
        }

    }
}
