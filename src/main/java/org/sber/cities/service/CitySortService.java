package org.sber.cities.service;

import org.sber.cities.domain.City;

public interface CitySortService {
    Iterable<City> sortByName(Iterable<City> source);

    Iterable<City> sortByDistrictAndName(Iterable<City> source);
}
