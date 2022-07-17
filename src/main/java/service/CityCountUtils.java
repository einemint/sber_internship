package service;

import model.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityCountUtils {

    public static void getCitiesCountByRegion(List<City> cities) {
        Map<String, Integer> citiesCount = new HashMap<>();

        for (City city : cities) {
            citiesCount.merge(city.getRegion(), 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> entry : citiesCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
