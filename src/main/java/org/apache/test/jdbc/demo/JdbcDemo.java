package org.apache.test.jdbc.demo;


import java.sql.*;

/**
 * Created by meijunjie on 2019/1/30.
 */
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册驱动 static
        Class.forName("com.mysql.jdbc.Driver");

        String dbUrl = "jdbc:mysql://localhost:3306/t_wp_user";
        String dbUsername = "root";
        String dbPassword = "123456";
        // 2. 创建数据库连接
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        // 3. 得到执行SQL的Statement
        Statement statement = connection.createStatement();

        String sql = "select * from t_application";

        // 查询
        ResultSet resultSet = statement.executeQuery(sql);

//        int changeID = statement.executeUpdate("update t_application set application_name='fuck' WHERE id=1");


        while (resultSet.next()){
            // resultSet.getMetaData() 表字段元数据
            System.out.println(resultSet.getMetaData().toString());
            System.out.println(resultSet.getMetaData().getColumnName(1) + ": " + resultSet.getString(1));
            System.out.println(resultSet.getMetaData().getColumnName(2) + ": " + resultSet.getString(2));
            System.out.println(resultSet.getMetaData().getColumnName(3) + ": " + resultSet.getString(3));
            System.out.println(resultSet.getMetaData().getColumnName(4) + ": " + resultSet.getString(4));
            System.out.println(resultSet.getMetaData().getColumnName(5) + ": " + resultSet.getString(5));
            System.out.println("---------------------------------------------");

        }
        resultSet.close();
        connection.close();

    }
}
