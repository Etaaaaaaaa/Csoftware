package com.teaeta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testJDBC {
    //使用main方法 实现mysql curd
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //0.注册驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1.创建连接
        //1-1 建立所需参数
        String url="jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC&useSSL=false";
        String user="root";
        String password="Lyq.0809";
        //1-2 创建并获取连接
        Connection conn= DriverManager.getConnection(url,user,password);
        //2.创建sql语句容器对象
        //2-1 写sql语句
        String sql="insert into users values(null,'ZhangSan','password',20,now(),1.1,now())";
        //2-2 创建语句容器
        PreparedStatement psTmt=conn.prepareStatement(sql);
        int result=psTmt.executeUpdate();
        System.out.println(result);
    }
}
