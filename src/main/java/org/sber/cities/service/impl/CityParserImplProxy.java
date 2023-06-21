package org.sber.cities.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sber.cities.domain.City;
import org.sber.cities.service.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Primary
@Slf4j
public class CityParserImplProxy implements CSVParser<City> {

    private final CSVParser<City> parser;

    @Autowired
    public CityParserImplProxy(@Qualifier("cityParser") CSVParser<City> parser) {
        this.parser = parser;
    }

    @Override
    public Iterable<City> parse(String location) throws Exception {
        try {
            return parser.parse(location);
        } catch (Exception e) {
            log.error("File \"%s\" does not exist or it is not in .csv format".formatted(location));
            System.exit(1);
            return null;
        }
    }
}
