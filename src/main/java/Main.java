import model.City;
import service.LargestPopulationUtils;
import service.SortUtils;

import java.io.IOException;
import java.util.Arrays;

import static service.CityUtils.printData;
import static service.CityUtils.readDataFromCsv;

public class Main {
    public static final String DATA_PATH = "src/main/data/city_ru.csv";

    public static void main(String[] args) throws IOException {
        printData(LargestPopulationUtils.getLargestPopulation(LargestPopulationUtils.getArray(readDataFromCsv(DATA_PATH))));
        City[] cities = LargestPopulationUtils.getArray(readDataFromCsv(DATA_PATH));
        LargestPopulationUtils.quickSortByPopulation(cities, 0, cities.length - 1);
        printData(Arrays.asList(cities[cities.length - 1]));
    }
}
