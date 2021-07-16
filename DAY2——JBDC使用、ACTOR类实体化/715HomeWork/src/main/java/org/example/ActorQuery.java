package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActorQuery {
    public List<Actor> ActorQueryAll() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1.创建连接
        //1-1 建立所需参数
        String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Lyq.0809";
        //1-2 创建并获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM Actor";
        List<Actor> userList = new ArrayList<Actor>();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            Actor act = new Actor();
            act.setActorId(rs.getLong("actor_id"));
            act.setFirstName(rs.getString("first_name"));
            act.setLastName(rs.getString("last_name"));
            act.setLastUpdate(rs.getDate("last_update"));
            userList.add(act);
        }
        conn.close();
        return userList;
    }
    public List<Actor> ActorQueryByParams(String name) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1.创建连接
        //1-1 建立所需参数
        String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Lyq.0809";
        //1-2 创建并获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        StringBuilder sql = new StringBuilder("SELECT * FROM actor WHERE first_name='"+name+"'");
        List<Actor> userList = new ArrayList<Actor>();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        while(rs.next()) {
            Actor act = new Actor();
            act.setActorId(rs.getLong("actor_id"));
            act.setFirstName(rs.getString("first_name"));
            act.setLastName(rs.getString("last_name"));
            act.setLastUpdate(rs.getDate("last_update"));
            userList.add(act);
        }
        conn.close();
        return userList;
    }
    public void addUser(Actor actor) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1.创建连接
        //1-1 建立所需参数
        String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Lyq.0809";
        //1-2 创建并获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "INSERT INTO actor(actor_id, first_name, last_name, last_update) "
                + " VALUES(?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, actor.getActorId());
        pstmt.setString(2, actor.getFirstName());
        pstmt.setString(3, actor.getLastName());
        pstmt.setDate(4, actor.getLastUpdate());
        pstmt.execute();
        conn.close();
    }
    public void deleteUser(int id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1.创建连接
        //1-1 建立所需参数
        String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Lyq.0809";
        //1-2 创建并获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.execute();
        conn.close();
    }
    public void update(Actor a) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1.创建连接
        //1-1 建立所需参数
        String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Lyq.0809";
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "UPDATE actor SET first_name=?, last_name=?,last_update=?"
                + " WHERE actor_id=?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, a.getFirstName());
        pstmt.setString(2, a.getLastName());
        pstmt.setDate(3, a.getLastUpdate());
        pstmt.setLong(4, a.getActorId());

        pstmt.executeUpdate();
    }

}
