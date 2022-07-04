package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.City;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CityUtils {
    public static void readDataFromCsv (String path) throws IOException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            createDataObject(line);
        }
        scanner.close();
    }

    private static void createDataObject(String line) throws JsonProcessingException {
        String[] fragments = line.split(";");

        City city = new City();
        city.setName(fragments[1]);
        city.setRegion(fragments[2]);
        city.setDistrict(fragments[3]);
        city.setPopulation(Integer.parseInt(fragments[4]));
        if (fragments.length == 6) {
            city.setFoundation(fragments[5]);
        }

        printData(city);
    }

    private static void printData (City city) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("City" + mapper.writeValueAsString(city));
    }
}
