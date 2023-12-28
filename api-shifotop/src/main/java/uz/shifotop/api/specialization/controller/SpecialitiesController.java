package uz.shifotop.api.specialization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.specialization.dto.SpecialityCreateDto;
import uz.shifotop.api.specialization.dto.SpecialityResponseDto;
import uz.shifotop.api.specialization.service.SpecialitiesService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/specs")
public class SpecialitiesController
{

	private final SpecialitiesService specsService;

	@Operation(
			summary = "Add a new speciality",
			description = "Creates a new speciality with the provided details.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Speciality successfully added",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = SpecialityResponseDto.class))),
					@ApiResponse(responseCode = "400", description = "Invalid speciality details provided")
			}
	)
	@PostMapping
	public ResponseEntity<SpecialityResponseDto> addSpeciality(
			@Parameter(description = "Speciality creation details", required = true)
			@RequestBody SpecialityCreateDto createDto)
	{
		return ResponseEntity.ok(specsService.addSpeciality(createDto));
	}
}
