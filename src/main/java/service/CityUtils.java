package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.City;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {
    public static List<City> readDataFromCsv (String path) throws IOException {
        Scanner scanner = new Scanner(new File(path));
        List<City> cities = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            cities.add(createDataObject(line));
        }
        scanner.close();

        return cities;
    }

    private static City createDataObject(String line) throws JsonProcessingException {
        String[] fragments = line.split(";");

        City city = new City();
        city.setName(fragments[1]);
        city.setRegion(fragments[2]);
        city.setDistrict(fragments[3]);
        city.setPopulation(Integer.parseInt(fragments[4]));
        if (fragments.length == 6) {
            city.setFoundation(fragments[5]);
        }

        return city;
    }

    public static void printData (List<City> cities) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        for (City city : cities) {
            System.out.println("City" + mapper.writeValueAsString(city));
        }
    }
}
