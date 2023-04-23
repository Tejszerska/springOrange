package pl.sda.springrestapp1.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rental.prop")
@Slf4j
@Setter
@Getter
@ToString
public class Rental implements CommandLineRunner {
    private String name;
    private String year;
    private String owner;
    public void printDataFromProperties(){
        log.info("Nazwa wypożyczalni: " + name + ", rok założenia: " + year + " właściciel: " + owner);
    }

    @Override
    public void run(String... args) throws Exception {
        printDataFromProperties();
    }
}
