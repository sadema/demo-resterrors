package nl.kristalsoftware.resterrortest.demoresterrors.customer;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error")
@ResponseBody
public class CustomerControllerAdvice {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    VndErrors customerNotFoundException(CustomerNotFoundException e) {
        return this.error(e, String.valueOf(e.getCustomerId()));
    }

    private <E extends Exception> VndErrors error(E e, String logRef) {
        String msg = Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
        return new VndErrors(logRef, msg);
    }
}
