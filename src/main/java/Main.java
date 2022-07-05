import service.SortUtils;

import java.io.IOException;

import static service.CityUtils.printData;
import static service.CityUtils.readDataFromCsv;

public class Main {
    public static final String DATA_PATH = "src/main/data/city_ru.csv";

    public static void main(String[] args) throws IOException {
        printData(SortUtils.sortByName(readDataFromCsv(DATA_PATH)));
        printData(SortUtils.sortByDistrictAndName(readDataFromCsv(DATA_PATH)));
    }
}
