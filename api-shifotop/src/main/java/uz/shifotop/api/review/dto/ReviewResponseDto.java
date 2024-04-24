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
    private long id;
    private long patientId;
    private long doctorId;
    private long clinicId;
    private int rating;
    private String content;
    private LocalDateTime reviewTime; //todo might be problem, coz it was string before, when I inserted the data
}
