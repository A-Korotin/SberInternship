package org.sber.cities.service;

import org.sber.cities.domain.City;

import java.util.Map;

public interface CityGroupService {
    Map<String, Long> countByRegion(Iterable<City> source);
}
