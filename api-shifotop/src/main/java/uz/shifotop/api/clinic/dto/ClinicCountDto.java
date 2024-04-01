package uz.shifotop.api.clinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClinicCountDto
{
	@JsonProperty("name")
	private String specName;
	@JsonProperty("count")
	private int clinicsCount;
}
