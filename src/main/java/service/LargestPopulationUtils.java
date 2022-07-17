package service;

import model.City;

import java.util.*;

public class LargestPopulationUtils {
    public static City[] getArray (List<City> cities) {
        return cities.toArray(new City[0]);
    }

    public static List<City> getLargestPopulation (City[] cities) {
        Optional<City> city = Arrays.stream(cities).max((o1, o2) -> Comparator.comparing(City::getPopulation)
                .compare(o1, o2));

        return city.map(Arrays::asList).orElseGet(ArrayList::new);
    }

    public static void quickSortByPopulation(City[] cities, int low, int high) {
        if (cities.length == 0) return;

        if (low >= high) return;

        int middle = low + (high - low) / 2;
        City pivot = cities[middle];

        int i = low, j = high;
        while (i <= j) {
            while (cities[i].getPopulation() < pivot.getPopulation()) {
                i++;
            }

            while (cities[j].getPopulation() > pivot.getPopulation()) {
                j--;
            }

            if (i <= j) {
                City temp = cities[i];
                cities[i] = cities[j];
                cities[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSortByPopulation(cities, low, j);

        if (high > i)
            quickSortByPopulation(cities, i, high);
    }
}
