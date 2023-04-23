package pl.sda.springrestapp1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springrestapp1.service.workshop.WorkshopInfo;
import pl.sda.springrestapp1.service.workshop.WorkshopProperties;

//@RestController
@RequestMapping("/workshop")
@RequiredArgsConstructor
public class WorkshopController {
    private final WorkshopInfo workshopInfo;
    private final WorkshopProperties workshopProperties;
    @GetMapping
    public ResponseEntity<Void> printWorkshopInfo(){
        workshopInfo.showDataFromProperties();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v2")
    public ResponseEntity<Void> printWorkshopProperties(){
        workshopProperties.printDataFromProperties();
        return ResponseEntity.ok().build();
    }
}
