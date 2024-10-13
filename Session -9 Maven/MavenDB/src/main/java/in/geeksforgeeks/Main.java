package in.geeksforgeeks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) throws SQLException {



        System.out.println("hello world ");

        Connection connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testmaven",
                "root", "root");

        Statement statement = connection.createStatement();

        statement.execute("create table Person_12 (id int ,name varchar(30))");

        System.out.println(" after ");

        AddCalc calc= new AddCalc();
    }
}