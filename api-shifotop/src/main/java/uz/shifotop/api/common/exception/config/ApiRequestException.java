package uz.shifotop.api.common.exception.config;

import lombok.Getter;

@Getter
public class ApiRequestException extends RuntimeException {
    private final int status;

    public ApiRequestException(String message, int status) {
        super(message);
        this.status = status;
    }
}

