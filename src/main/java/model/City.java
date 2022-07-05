package model;

import lombok.Data;

import java.util.Comparator;

@Data
public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    public int compareByDistrictAndName(City o){
        return Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName)
                .compare(this, o);
    }

    public int compareByName(City o){
        return o.getName().compareToIgnoreCase(this.getName());
    }
}
