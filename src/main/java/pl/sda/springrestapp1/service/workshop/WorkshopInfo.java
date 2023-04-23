package pl.sda.springrestapp1.service.workshop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class WorkshopInfo {
    @Value("${workshop.info.author}")
    private String author;
    @Value("${workshop.info.name}")
    private String name;
    @Value("${workshop.info.year}")
    private int year;

    public void showDataFromProperties(){
        log.info("Author: " + author + ", name: " + name + ", year: "+ year);
    }
}
