package uz.shifotop.api.common.exception;

import org.springframework.http.HttpStatus;
import uz.shifotop.api.common.exception.config.ApiRequestException;

public class BadRequestException extends ApiRequestException {
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST.value());
    }
}

