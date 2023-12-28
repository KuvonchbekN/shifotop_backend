package uz.shifotop.api.common.exception;


import org.springframework.http.HttpStatus;
import uz.shifotop.api.common.exception.config.ApiRequestException;

public class BadCredentialsException extends ApiRequestException {
    public BadCredentialsException(String message) {
        super(message, HttpStatus.UNAUTHORIZED.value());
    }
}
