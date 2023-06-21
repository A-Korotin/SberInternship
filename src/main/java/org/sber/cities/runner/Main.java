package org.sber.cities.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sber.cities.domain.City;
import org.sber.cities.service.CSVParser;
import org.sber.cities.service.CityGroupService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class Main implements CommandLineRunner {

    private final CSVParser<City> parser;
    private final CityGroupService groupService;

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            log.error("Please, provide CSV filepath as command line argument.");
            System.exit(1);
        }

        String location = args[0];
        Iterable<City> cities = parser.parse(location);

        Map<String, Long> distribution = groupService.countByRegion(cities);

        distribution.forEach((r, c) -> System.out.printf("%s - %d%n", r, c));
    }
}
