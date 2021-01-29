import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    String url="jdbc:mysql://itsovy.sk:3306/world_x";
    String username="mysqluser";
    String password="Kosice2021";


    public void showCities(String country){
        String query= "SELECT City.Name,CountryCode" +
                "FROM City"+
                "INNER JOIN country ON country.code = city.countryCode"+
                "WHERE country.name LIKE ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,username,password);
            if (conn!=null){
                System.out.println("Succes");
                PreparedStatement ps= conn.prepareStatement(query);
                ps.setString(1, countryCode1);
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                    String city= rs.getString("Name");
                    String code= rs.getString("CountryCode");
                    System.out.println(city+""+code);
                }
            } conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
