package uz.shifotop.api.common.exception;

import uz.shifotop.api.common.exception.config.ApiRequestException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiRequestException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }
}
