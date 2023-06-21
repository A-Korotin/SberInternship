package org.sber.cities.service.impl;

import org.sber.cities.domain.City;
import org.sber.cities.service.CSVParser;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service("cityParser")
public class CityParserImpl implements CSVParser<City> {


    private String tryGetArgElseDefault(String[] args, int targetIndex, String def) {
        try {
            return args[targetIndex];
        } catch (IndexOutOfBoundsException e) {
            return def;
        }
    }


    private City parseCity(String csvRecord) {
        City city = new City();

        String[] args = csvRecord.split(";");

        city.setId(Long.parseLong(tryGetArgElseDefault(args, 0, "0")));
        city.setName(tryGetArgElseDefault(args, 1, ""));
        city.setRegion(tryGetArgElseDefault(args, 2, ""));
        city.setDistrict(tryGetArgElseDefault(args, 3, ""));
        city.setPopulation(Long.parseLong(tryGetArgElseDefault(args, 4, "0")));
        city.setFoundation(tryGetArgElseDefault(args, 5, ""));

        return city;
    }

    @Override
    public Iterable<City> parse(String location) throws Exception {
        Scanner scanner = new Scanner(new File(location));
        List<City> output = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String record = scanner.nextLine();
            output.add(parseCity(record));
        }

        return output;
    }
}
