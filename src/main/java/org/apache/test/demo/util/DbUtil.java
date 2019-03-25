package org.apache.test.demo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author meijunjie
 * @date 2019/1/31
 */
public class DbUtil {

    private static SqlSession SQL_SESSION = null;
    private static SqlSessionFactory SQL_SESSION_FACTORY = null;
    private static final String CONFIG_RESOURCE = "demo/mybatis-demo-configuration.xml";

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream(CONFIG_RESOURCE);
            SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(inputStream);
            SQL_SESSION = SQL_SESSION_FACTORY.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return SQL_SESSION;
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return SQL_SESSION_FACTORY;
    }

}
