package nl.kristalsoftware.resterrortest.demoresterrors.customer;

import lombok.Getter;

@Getter
public class CustomerNotFoundException extends Exception {
    private Long customerId;

    public CustomerNotFoundException(Long customerId) {
        super("Customer# " + customerId + " was not found");
        this.customerId = customerId;
    }
}
