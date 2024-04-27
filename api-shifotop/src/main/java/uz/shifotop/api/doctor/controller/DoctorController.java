package uz.shifotop.api.doctor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/doctors")
@Slf4j
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
		log.info("Get all doctors");
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
		log.info("Get doctor by ID: {}", doctorId);
		return ResponseEntity.ok(doctorService.getDoctor(doctorId));
	}

	@GetMapping("/type/{type}")
	public ResponseEntity<List<DoctorResponseDto>> getDoctorByType(@PathVariable String type){
		List<DoctorResponseDto> allDoctors = doctorService.getAllDoctorsBySpec(type);
		log.info("Get doctor by type: {}", type);
//		doctorService.getDoctorListBySpeciality();
		return ResponseEntity.ok(allDoctors);
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
		log.info("Create doctor: {}", dto);
		return ResponseEntity.ok(doctorService.createDoctor(dto));
	}

	//create an endpoint for getting doctor types and the number of doctors in that category
	//todo later retrieve the data by popularity
	@GetMapping("/speciality-count") //test this endpoint
	public ResponseEntity<List<DoctorSpecialityCountDto>> getDoctorsSpecialitiesWithCount(){
		log.info("Get doctors by speciality count");
		var response = doctorService.getDoctorsSpecialitiesWithCount();
		return ResponseEntity.ok(!response.isEmpty() ? response: new ArrayList<>() );
	}

	@GetMapping("/doctors-count")
	public ResponseEntity<Long> getDoctorsCount(){
		log.info("Get doctors count");
		return ResponseEntity.ok(doctorService.getDoctorsCount());
	}


}
