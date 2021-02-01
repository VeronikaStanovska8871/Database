package output;

import entity.City;

import java.util.List;

public class output {
    public void printCities(List<City> list){
        for(City c : list){
            System.out.println(c.getName() );
        }
    }
}
