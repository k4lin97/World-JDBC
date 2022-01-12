import application.City;
import dao.city.CityDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CityDAO dao = new CityDAO();
        List<City> list = dao.getAll();

//        for (City city: list) {
//            System.out.println(city);
//        }

        list.stream()
                .filter(city -> city.getDistrict().equals("Zuid-Holland"))
                .forEach(System.out::println);
    }
}
