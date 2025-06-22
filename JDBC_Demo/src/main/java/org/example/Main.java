package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbcdb";
            String username = "root";
            String password = "root";
//            String sql="INSERT INTO employee (id, name, age) VALUES (1, 'John Doe', 30);";
            String query="Select * from employee;";
            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();
//            Statement pst = con.prepareStatement();
//            CallableStatement cs =con.prepareCall();
//            st.executeUpdate(sql);

            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID   : " + id);
                System.out.println("Name : " + name);
                System.out.println("Age  : " + age);
                System.out.println("-------------------");
            }
            con.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}