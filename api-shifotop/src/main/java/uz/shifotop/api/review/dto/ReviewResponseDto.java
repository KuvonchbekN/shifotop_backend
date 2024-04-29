package uz.shifotop.api.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long clinicId;
    private Integer rating;
    private String content;
    private LocalDateTime reviewTime;
}
