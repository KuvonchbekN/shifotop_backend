package uz.shifotop.api.common.exception;

import uz.shifotop.api.common.exception.config.ApiRequestException;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApiRequestException {
    public ForbiddenException(String message) {
        super(message, HttpStatus.FORBIDDEN.value());
    }
}

