package org.sber.cities.service.impl;

import org.sber.cities.domain.City;
import org.sber.cities.service.CitySortService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CitySortServiceImpl implements CitySortService {

    @Override
    public Iterable<City> sortByName(Iterable<City> source) {
        return StreamSupport.stream(source.spliterator(), false)
                .sorted((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<City> sortByDistrictAndName(Iterable<City> source) {
        return StreamSupport.stream(source.spliterator(), false)
                .sorted(Comparator.comparing(City::getName))
                .sorted(Comparator.comparing(City::getDistrict))
                .collect(Collectors.toList());
    }
}
