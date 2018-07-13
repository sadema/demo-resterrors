package nl.kristalsoftware.resterrortest.demoresterrors.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Data
public class Customer {

    private Long id;

    private String name;

    private String icon;

    private BigDecimal premiumAmount;

}
