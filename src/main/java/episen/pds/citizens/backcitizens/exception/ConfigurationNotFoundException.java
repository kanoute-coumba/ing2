package episen.pds.citizens.backcitizens.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConfigurationNotFoundException extends RuntimeException{

    public ConfigurationNotFoundException(String msg) {
        super(msg);
    }
}
