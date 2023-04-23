package pl.sda.springrestapp1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.springrestapp1.model.Car;
import pl.sda.springrestapp1.repository.CarRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {

    private final CarRepository carRepository; // jesli zmienna jest konieczna do zainicjalizowania klasy, dobrze zrobic final. Wymaga to zainicjalizowania zmiennej

    public List<Car> getAllCars(){
return carRepository.getAllCars();
    }
    public Car getCarByRegistrationNumber(String registrationNumber){
        Optional<Car> carByRegistrationNumber =  carRepository.getCarByRegistrationNumber(registrationNumber);
    return carByRegistrationNumber.orElse(null);
    }

    public List<Car> getCarsByFuelType(String fuel){
       return carRepository.getCarsByFuel(fuel);
    }

    public List<Car> getCarsByProductionYear(String productionYear){
        return carRepository.getCarsByYear(productionYear);
    }

    public Car updateCarWithNewValue(String registrationNumber, BigDecimal newValue){
        Optional<Car> carByRegistrationNumber =  carRepository.getCarByRegistrationNumber(registrationNumber);
if(carByRegistrationNumber.isPresent()){
    Car car = carByRegistrationNumber.get();
    car.setValue(newValue);
    return car;
        } else {
    log.info("Nie znaleziono takiej rejestracji: " + registrationNumber);
    return null;
        }
    }

    public List<Car> addNewCar(String registrationNumber, Car newCar){
        return carRepository.addNewCar(registrationNumber, newCar);
    }


}
