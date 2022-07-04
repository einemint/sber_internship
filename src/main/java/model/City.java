package model;

import lombok.Data;

@Data
public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;
}
