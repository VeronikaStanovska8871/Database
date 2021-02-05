import java.sql.*;
import java.util.concurrent.ExecutionException;

public class Database {
    String url="jdbc:mysql://itsovy.sk:3306/world_x";
    String username="mysqluser";
    String password="Kosice2021";


    public void showCities(String country){
        String query= "SELECT City.Name,JSON_EXTRACT(Info,'$.Population') AS Population" +
                "FROM City"+
                "INNER JOIN country ON country.code = city.countryCode"+
                "WHERE country.name LIKE ? ORDER BY Population DESC";
        try {
            Connection conn = getConnection();
            if (conn!=null){
                System.out.println("Succes");
                PreparedStatement ps= conn.prepareStatement(query);
                ps.setString(1, country);
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                    String city= rs.getString("Name");
                    int pop= rs.getInt("Population");
                    System.out.println(city+"("+pop+")");
                    City city= new City(name,pop);
                    list.add(city);
                }
            } conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection(url,username,password);
        return conn;
    }

    public getCountryInfo(String country){
      String query="SELECT country.name, country.code, city.name"+
              "FROM country"+
              "INNER JOIN city ON country.Capital= city.ID"+
              "WHERE country.name LIKE ?";
      try {
          Connection con=getConnection();
          PreparedStatement ps=con.prepareStatement(query);
          ps.setString(1,country);
          ResultSet rs=ps.executeQuery();
          if (rs.next()){
              String code3=rs.getString("country.code");
              String capitalCity=rs.getString(city.name);
              System.out.println(code3+""+capitalCity);
          }
      }catch (Exeption e){
          e.printStackTrace();
      }

        return countryInfo;
    }

    public getCountryCode (String name){
        if (name=null || name.equalsIgnoreCase(""))
            return null;
        try {
         Connection con= getConnection();
         String query="SELECT Code FROM country WHERE Name LIKE ?";
         PreparedStatement ps=con.prepareStatement(query);
         ps.setString(1, name);
         ResultSet rs=ps.executeQuery();
         if (rs.next()){
             String code = rs.getString("Code");
             return code;
         }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public updatePopulation(){
        try{
            Connection con= getConnection();
            String query="";
        }catch (Exception e){
        e.printStackTrace();
    }

    }
}
