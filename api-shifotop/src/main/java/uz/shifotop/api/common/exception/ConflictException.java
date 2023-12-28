package uz.shifotop.api.common.exception;

import uz.shifotop.api.common.exception.config.ApiRequestException;
import org.springframework.http.HttpStatus;

public class ConflictException extends ApiRequestException {
    public ConflictException(String message) {
        super(message, HttpStatus.CONFLICT.value());
    }
}
