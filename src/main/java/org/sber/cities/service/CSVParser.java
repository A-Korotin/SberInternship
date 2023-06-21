package org.sber.cities.service;

public interface CSVParser<T> {
    Iterable<T> parse(String location) throws Exception;
}
