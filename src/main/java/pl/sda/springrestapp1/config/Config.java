package pl.sda.springrestapp1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.springrestapp1.controller.WorkshopController;
import pl.sda.springrestapp1.repository.CarRepository;
import pl.sda.springrestapp1.repository.InMemoryCarRepository;
import pl.sda.springrestapp1.service.CarService;
import pl.sda.springrestapp1.service.workshop.WorkshopInfo;
import pl.sda.springrestapp1.service.workshop.WorkshopProperties;

@Configuration
public class Config {
@Autowired
private WorkshopInfo workshopInfo;
@Autowired
private WorkshopProperties workshopProperties;
    @Bean
    public CarRepository carRepository(){
        return new InMemoryCarRepository();
    };

    @Bean
    public CarService carService(){
        return new CarService(carRepository());
    }

    @Bean
    public WorkshopController workshopController(){
        return new WorkshopController(workshopInfo, workshopProperties);
    }
//    @Bean
//    public WorkshopInfo workshopInfo(){
//        return new WorkshopInfo();
//    }
//
//    @Bean
//    public WorkshopProperties workshopProperties(){
//        return new WorkshopProperties();
//    }
}
