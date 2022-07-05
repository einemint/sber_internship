package service;

import model.City;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtils {
    public static List<City> sortByName (List<City> cities) {
        Comparator<City> comparator = (o1, o2) -> o1.compareByName(o2);
        Collections.sort(cities, comparator);

        return cities;
    }

    public static List<City> sortByDistrictAndName (List<City> cities) {
        Comparator<City> comparator = (o1, o2) -> o1.compareByDistrictAndName(o2);
        Collections.sort(cities, comparator);

        return cities;
    }
}
