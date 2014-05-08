package com.github.bingoohuang.designpatterns.flyweight;


import java.util.concurrent.ConcurrentHashMap;

public class CityFactory {
    // Flyweight objects pool
    private ConcurrentHashMap<String, City> cities = new ConcurrentHashMap<>();

    private static CityFactory cityFactory = new CityFactory();

    public static CityFactory getInstance() {
        return cityFactory;
    }

    public static City getCity(String name) {
        ConcurrentHashMap<String, City> cities = getInstance().cities;
        City city = cities.get(name);
        if (city != null) return city;

        city = new City(name);
        City old = cities.putIfAbsent(name, city);

        return old == null ? city : old;
    }
}
