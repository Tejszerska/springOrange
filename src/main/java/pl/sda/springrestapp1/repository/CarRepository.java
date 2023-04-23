package pl.sda.springrestapp1.repository;

import pl.sda.springrestapp1.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> getAllCars();
    Optional<Car> getCarByRegistrationNumber (String registrationNumber);
// nie optional, bo lista jest bezpeiczna. zainicjalizujemy ja wiec nie bedzie null pointer exception
    List<Car>getCarsByFuel(String fuel);
    List<Car>getCarsByYear(String productionYear);
    List<Car> addNewCar(String registrationNumber, Car newCar);
    void deleteCarByRegistrationNumber(String registrationNumber);


}
