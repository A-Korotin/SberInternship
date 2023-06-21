package org.sber.cities.domain;

import lombok.Data;
import lombok.ToString;

@Data
public class City {
    @ToString.Exclude
    private long id;

    private String name;

    private String region;

    private String district;

    private long population;

    private String foundation;

}
