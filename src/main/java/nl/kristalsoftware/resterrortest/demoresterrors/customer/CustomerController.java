package nl.kristalsoftware.resterrortest.demoresterrors.customer;

import lombok.AllArgsConstructor;
import nl.kristalsoftware.resterrortest.demoresterrors.IconConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CustomerController {

    private IconConfiguration iconConfiguration;

    @RequestMapping(path="/customers/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable Long id) throws Exception {
        if (id == 1L) {
            System.out.println(iconConfiguration.getIcons().size());
            String icon = iconConfiguration.getIcons().get("Z1OA20000A0000");
            return new Customer(1L, "John Doe", icon, null);
        }
        else {
            if (id == 3L) {
                throw new IllegalStateException("IllegalState");
            }
        }
        throw new CustomerNotFoundException(id);
    }

}
