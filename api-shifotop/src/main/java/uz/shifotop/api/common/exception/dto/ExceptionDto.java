package uz.shifotop.api.common.exception.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    private String message;
    private int status;
}
