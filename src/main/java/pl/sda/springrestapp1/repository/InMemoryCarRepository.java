package pl.sda.springrestapp1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.sda.springrestapp1.model.Car;
import pl.sda.springrestapp1.service.CarService;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

//@Repository
public class InMemoryCarRepository implements CarRepository {

private static final Map<String, Car> carMap;

static {
    carMap = new HashMap<>();
    carMap.put("ABC1234", Car.builder()
                    .model("Deo")
                    .brand("BMW")
                    .productionYear("2015")
                    .fuelType("gas")
                    .value(new BigDecimal(40000))
            .build());

    carMap.put("NTF5446", Car.builder()
            .model("Alfa")
            .brand("Opel")
            .productionYear("2015")
            .fuelType("gas")
            .value(new BigDecimal(10000))
            .build());

    carMap.put("GOP4561", Car.builder()
            .model("Romeo")
            .brand("Mustang")
            .productionYear("2022")
            .fuelType("diesel")
            .value(new BigDecimal(500000))
            .build());

    carMap.put("MOP1546", Car.builder()
            .model("Cool")
            .brand("Fiat")
            .productionYear("1995")
            .fuelType("hybrid")
            .value(new BigDecimal(600))
            .build());

    carMap.put("BPN7845", Car.builder()
            .model("Czerwony")
            .brand("Najszabszy")
            .productionYear("2015")
            .fuelType("diesel")
            .value(new BigDecimal(40000))
            .build());

}
    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(carMap.values());
    }

    @Override
    public Optional<Car> getCarByRegistrationNumber(String registrationNumber) {
        return Optional.ofNullable(carMap.get(registrationNumber));
    }

    @Override
    public List<Car> getCarsByFuel(String fuel) {
        return carMap.values().stream().filter( i -> fuel.equals(i.getFuelType()) ).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByYear(String productionYear) {
        return carMap.values().stream().filter(i -> productionYear.equals(i.getProductionYear())).collect(Collectors.toList());
    }

    @Override
    public List<Car> addNewCar(String registrationNumber, Car newCar) {
    carMap.put(registrationNumber, newCar);
        return new ArrayList<>(carMap.values());
    }

    @Override
    public void deleteCarByRegistrationNumber(String registrationNumber) {
    //if carMap.containsKey(registrationNumber){
        carMap.remove(registrationNumber);
        System.out.println("Usunięto samochód o rejestracji: " + registrationNumber);
    }


}
