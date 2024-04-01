package uz.shifotop.api.doctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSpecialityCountDto
{
	@JsonProperty("name")
	private String specName;
	@JsonProperty("count")
	private int doctorsCount;
}