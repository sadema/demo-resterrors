package nl.kristalsoftware.resterrortest.demoresterrors;

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
public class CommonControllerAdvice {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    VndErrors illegalStateException(IllegalStateException e) {
        return this.error(e, String.valueOf(e.getMessage()));
    }

    private <E extends Exception> VndErrors error(E e, String logRef) {
        String msg = Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
        return new VndErrors(logRef, msg);
    }

}
