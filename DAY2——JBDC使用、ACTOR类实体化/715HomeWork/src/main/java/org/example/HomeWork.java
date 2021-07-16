package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) throws Exception {
        //0.注册驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1.创建连接
        //1-1 建立所需参数
        String url = "jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Lyq.0809";
        //1-2 创建并获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        conn.close();
        ActorQuery a = new ActorQuery();
        System.out.println("Original Data:");
        List<Actor> userList = a.ActorQueryAll();
        for (Actor actor : userList) {
            System.out.println(actor.getActorId() + " " + actor.getFirstName() + ' ' + actor.getLastName() + ' ' + actor.getLastUpdate());
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Choice Your operation:");
        System.out.println("1.add");
        System.out.println("2.delete");
        System.out.println("3.select");
        System.out.println("4.update");
        int choice = input.nextInt();
        switch (choice) {
            case 1:

                Actor a2 = new Actor();
                a2.setActorId(4399);
                a2.setFirstName("LI");
                a2.setLastName("YuQi");
                a2.setLastUpdate(new Date(System.currentTimeMillis()));
                a.addUser(a2);
                List<Actor> r1 = a.ActorQueryAll();
                for (Actor actor : r1) {
                    System.out.println(actor.getActorId() + " " + actor.getFirstName() + ' ' + actor.getLastName() + ' ' + actor.getLastUpdate());
                }
                break;
            case 2:
                Actor a5 = new Actor();
                a5.setActorId(4399);
                a5.setFirstName("LI");
                a5.setLastName("YuQi");
                a5.setLastUpdate(new Date(System.currentTimeMillis()));
                a.addUser(a5);
                List<Actor> r9 = a.ActorQueryAll();
                for (Actor actor : r9) {
                    System.out.println(actor.getActorId() + " " + actor.getFirstName() + ' ' + actor.getLastName() + ' ' + actor.getLastUpdate());
                }
                System.out.print("input the ID you want to delete:  ");
                int deleteID=input.nextInt();
                a.deleteUser(deleteID);
                List<Actor> r2 = a.ActorQueryAll();
                for (Actor actor : r2) {
                    System.out.println(actor.getActorId() + " " + actor.getFirstName() + ' ' + actor.getLastName() + ' ' + actor.getLastUpdate());
                }
                break;
            case 3:
                System.out.print("input the first name you want to select:  ");
                String name=input.next();
                List<Actor> r3 = a.ActorQueryByParams(name);
                for (Actor actor : r3) {
                    System.out.println(actor.getActorId() + " " + actor.getFirstName() + ' ' + actor.getLastName() + ' ' + actor.getLastUpdate());
                }
                break;
            case 4:
                System.out.println("input the actor ID you want to update:  ");
                int updateID=input.nextInt();
                Actor a3 = new Actor();
                a3.setActorId(updateID);
                System.out.println("input the first name & last name from actor you want to update:  ");
                String fName= input.next();
                String lName= input.next();
                a3.setFirstName(fName);
                a3.setLastName(lName);
                a3.setLastUpdate(new Date(System.currentTimeMillis()));
                a.update(a3);
                List<Actor> r4 = a.ActorQueryAll();
                for (Actor actor : r4) {
                    System.out.println(actor.getActorId() + " " + actor.getFirstName() + ' ' + actor.getLastName() + ' ' + actor.getLastUpdate());
                }
        }


    }

}



