package pl.sda.springrestapp1.model;

import lombok.*;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Car {
    private String model;
    private String brand;
    private String productionYear;
    private BigDecimal value;
    private String fuelType;
}
