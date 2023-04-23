package pl.sda.springrestapp1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springrestapp1.model.Rental;

@RestController
@RequestMapping("rental")
@RequiredArgsConstructor
public class RentalController {
private final Rental rental;


    @GetMapping("/all")
    public ResponseEntity<Void> printWorkshopProperties(){
        rental.printDataFromProperties();
        return ResponseEntity.ok().build();
    }
}
