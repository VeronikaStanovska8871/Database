package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Database {
    private String url="jdbc:mysql://itsovy.sk:3306/world_x";
    private String username = "mysqluser";
    private String password = "Kosice2021!";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,username,password);
        return conn;
    }

    public boolean insertNewMonument (String code3, String city, String name){
        String query="SELECT country.code, city.name, city.monument";
    }


    public List <> getMonuments(){

    }
}

