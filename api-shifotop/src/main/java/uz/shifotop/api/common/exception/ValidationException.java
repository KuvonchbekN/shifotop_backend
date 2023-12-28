package uz.shifotop.api.common.exception;

import uz.shifotop.api.common.exception.config.ApiRequestException;
import org.springframework.http.HttpStatus;

public class ValidationException extends ApiRequestException {
    public ValidationException(String message) {
        super(message, HttpStatus.BAD_REQUEST.value());
    }
}
