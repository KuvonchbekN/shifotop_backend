package uz.shifotop.api.common.exception.config;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import uz.shifotop.api.common.exception.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<ExceptionDto> handleNonUniqueResultException(IncorrectResultSizeDataAccessException e) {
        log.info(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content(mediaType = "application/json")
            )
    })
    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<ExceptionDto> handleDemoShopGlobalException(ApiRequestException e) {
        log.info(e.getMessage());
        return ResponseEntity
                .status(e.getStatus())
                .body(new ExceptionDto(e.getMessage(), e.getStatus()));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content(mediaType = "application/json")
            )
    })
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionDto> handleAccessDeniedException(RuntimeException e) {
        log.info(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ExceptionDto(e.getMessage(), HttpStatus.FORBIDDEN.value()));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(mediaType = "application/json")
            )
    })
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return ResponseEntity.internalServerError()
                .body(new ExceptionDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(mediaType = "application/json")
            )
    })
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionDto> handleInvalidParameter(MethodArgumentNotValidException exception) {
        log.info(exception.getMessage());

        List<String> errorMessages = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .distinct()
                .toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDto(errorMessages.toString(), HttpStatus.BAD_REQUEST.value())
        );
    }

}

