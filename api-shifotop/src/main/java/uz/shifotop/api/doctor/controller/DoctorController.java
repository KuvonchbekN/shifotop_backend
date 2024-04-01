package uz.shifotop.api.doctor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.doctor.dto.DoctorCreateDto;
import uz.shifotop.api.doctor.dto.DoctorResponseDto;
import uz.shifotop.api.doctor.dto.DoctorSpecialityCountDto;
import uz.shifotop.api.doctor.service.DoctorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctors")
public class DoctorController
{

	private final DoctorService doctorService;

	@Operation(
			summary = "Get all doctors",
			description = "Retrieves a list of all doctors.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved all doctors",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = DoctorResponseDto.class))),
					@ApiResponse(responseCode = "500", description = "Internal server error")
			}
	)
	@GetMapping
	public ResponseEntity<List<DoctorResponseDto>> getAllDoctors()
	{
		return ResponseEntity.ok(doctorService.getAllDoctors());
	}

	@Operation(
			summary = "Get a doctor by ID",
			description = "Retrieves detailed information about a specific doctor by their ID.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved doctor details",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = DoctorResponseDto.class))),
					@ApiResponse(responseCode = "404", description = "Doctor not found")
			}
	)
	@GetMapping("/{id}")
	public ResponseEntity<DoctorResponseDto> getDoctorById(
			@Parameter(description = "ID of the doctor to be retrieved", required = true, example = "1")
			@PathVariable(value = "id") Long doctorId)
	{
		return ResponseEntity.ok(doctorService.getDoctor(doctorId));
	}


	@Operation(
			summary = "Get doctors by speciality",
			description = "Retrieves a list of doctors filtered by a specific speciality.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved doctors by speciality",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = DoctorResponseDto.class))),
					@ApiResponse(responseCode = "400", description = "Invalid speciality ID provided")
			}
	)
	@GetMapping("/speciality")
	public ResponseEntity<List<DoctorResponseDto>> getDoctorBySpeciality(
			@Parameter(description = "ID of the speciality", required = true, example = "1")
			@RequestParam(value = "spec_id") Long specId,
			@Parameter(description = "Size of the page", example = "10")
			@RequestParam(value = "size", required = false) Integer size,
			@Parameter(description = "Page number", example = "1")
			@RequestParam(value = "page", required = false) Integer page)
	{
		return ResponseEntity.ok(doctorService.getDoctorsBySpeciality(specId, page, size));
	}

	@Operation(
			summary = "Create a new doctor",
			description = "Creates a new doctor with the provided details.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Doctor successfully created",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = DoctorResponseDto.class))),
					@ApiResponse(responseCode = "400", description = "Invalid doctor details provided")
			}
	)
	@PostMapping
	public ResponseEntity<DoctorResponseDto> createDoctor(
			@Parameter(description = "Doctor details to be added", required = true)
			@Valid @RequestBody DoctorCreateDto dto)
	{
		return ResponseEntity.ok(doctorService.createDoctor(dto));
	}

	//create an endpoint for getting doctor types and the number of doctors in that category
	//todo later retrieve the data by popularity
	@GetMapping("/speciality-count") //test this endpoint
	public ResponseEntity<List<DoctorSpecialityCountDto>> getDoctorsSpecialitiesWithCount(){
		return ResponseEntity.ok(doctorService.getDoctorsSpecialitiesWithCount());
	}

	@GetMapping("/doctors-count")
	public ResponseEntity<Long> getDoctorsCount(){
		return ResponseEntity.ok(doctorService.getDoctorsCount());
	}


}
