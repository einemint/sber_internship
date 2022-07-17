import service.CityCountUtils;
import service.CityUtils;

import java.io.IOException;

public class Main {
    public static final String DATA_PATH = "src/main/data/city_ru.csv";

    public static void main(String[] args) throws IOException {
        CityCountUtils.getCitiesCountByRegion(CityUtils.readDataFromCsv(DATA_PATH));
    }
}
