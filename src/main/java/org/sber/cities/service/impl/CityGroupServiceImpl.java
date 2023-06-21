package org.sber.cities.service.impl;

import org.sber.cities.domain.City;
import org.sber.cities.service.CityGroupService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class CityGroupServiceImpl implements CityGroupService {

    @Override
    public Map<String, Long> countByRegion(Iterable<City> source) {
        List<City> cities = new ArrayList<>();
        source.forEach(cities::add);

        Map<String, Long> distribution = new HashMap<>();

        List<String> regions = cities.stream().map(City::getRegion).distinct().toList();
        regions.forEach(r -> distribution.put(r, cities.stream()
                .filter(c -> c.getRegion().equals(r)).count()));

        return distribution;
    }
}
