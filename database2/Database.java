package sample;

import java.sql.*;

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
        if (name==null || name.equals(""))
            return false;

        int cityID=existCity(code3,city);
        if (cityID==-1)
            return false;
        String query="INSERT INTO monument(name, city) values(?, ?)";
        try {
            Connection conn=getConnection();
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,cityID);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean existCity (String code3, String cityName){
        if (code3==null||cityName==null||code3.equals("")||cityName.equals(""))
            return -1;
        String query= "SELECT * FROM city WHERE name LIKE ? AND name LIKE ? ";
        try {
            Connection conn= getConnection();
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1, code3);
            ps.setString(2, cityName);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                int id=rs.getInt("id")
                        conn.close();
                        return id;
            }else {
                return -1;
            }
        }catch (Exception e){
         e.printStackTrace();
        }
        return -1;

    }finally {

    }
}

