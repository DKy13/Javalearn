package jdbc0509;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        //先创建数据库
        //1.创建DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        //2.设置dataSOurce的属性,为何数据库连接做准备
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java0509?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");
        //3.创建Connection对象,用来表示和数据库建立了一次链接
        Connection connection  = dataSource.getConnection();
        //4.如果链接没有问题,就可以操作数据库,核心是拼装sql语句
        // ?是占位符,下标从1开始,可以将具体的变量替换到?上
        String sql = "insert into student values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "胡歌");
        statement.setInt(2, 35);
        System.out.println(statement);
        //5.执行sql
        int ret = statement.executeUpdate();
        System.out.println(ret);
        //6. 释放相关资源,一定要先释放statement ,在释放connection  ,顺序不能错,顺序错了可能会出现资源泄露的情况
        statement.close();
        connection.close();
    }
}
