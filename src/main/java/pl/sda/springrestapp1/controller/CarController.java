package pl.sda.springrestapp1.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.springrestapp1.model.Car;
import pl.sda.springrestapp1.service.CarService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }

    @GetMapping
    public ResponseEntity<Car> getCarByRegistrationNumber(@RequestParam String registrationNumber) {
        Car carByRegistrationNumber = carService.getCarByRegistrationNumber(registrationNumber);
        if (carByRegistrationNumber != null) {
            return ResponseEntity.ok(carByRegistrationNumber);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/fuel/{fuelType}")
    public ResponseEntity<List<Car>> getCarsByFuelType(@PathVariable String fuelType) {
        List<Car> carsByFuel = carService.getCarsByFuelType(fuelType);
        return ResponseEntity.ok(carsByFuel);
    }

    //    @GetMapping("/year/{productionYear}")
//public ResponseEntity<List<Car>> getCarsByProductionYear (@PathVariable String productionYear){
//    List<Car> carsByYear = carService.getCarsByProductionYear(productionYear);
//    return ResponseEntity.ok(carsByYear);
//}
    @GetMapping("/year")
    public ResponseEntity<List<Car>> getCarsByProductionYear(@RequestParam String productionYear) {
        List<Car> carsByYear = carService.getCarsByProductionYear(productionYear);

        if (!carsByYear.isEmpty()) {
            return ResponseEntity.ok(carsByYear);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PatchMapping("/changeValue/{registrationNumber}")
    public ResponseEntity<Car> updateCarValue(@PathVariable String registrationNumber,
                                              @RequestBody BigDecimal newValue) {
        Car car = carService.updateCarWithNewValue(registrationNumber, newValue);

        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/{registrationNumber}")
    public ResponseEntity<List<Car>> createNewCar(@PathVariable String registrationNumber,
                                                  @RequestBody Car newCar) {
        List<Car> cars = carService.addNewCar(registrationNumber, newCar);
        return ResponseEntity.ok(cars);
    }


}
