package uz.shifotop.api.clinic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.clinic.dto.ClinicCountDto;
import uz.shifotop.api.clinic.dto.ClinicRequestDto;
import uz.shifotop.api.clinic.dto.ClinicResponseDto;
import uz.shifotop.api.clinic.dto.MedicalServiceRequestDto;
import uz.shifotop.api.clinic.dto.OrientalPlaceDto;
import uz.shifotop.api.clinic.dto.PageSettings;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.clinic.service.ClinicService;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecsRequestDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clinics")
@Validated
@Slf4j
public class ClinicController
{

	private final ClinicService clinicService;

	@Operation(summary = "Get all clinics",
			description = "Retrieves a list of all available clinics. Supports pagination.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved the list of clinics",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClinicResponseDto.class))),
					@ApiResponse(responseCode = "400", description = "Invalid request parameters")})
	@GetMapping
	public ResponseEntity<List<ClinicResponseDto>> getAllClinics(@Valid @ParameterObject PageSettings pageSettings)
	{
		return ResponseEntity.ok(clinicService.getAllClinics(pageSettings));
	}


	@Operation(
			summary = "Get a clinic by ID",
			description = "Retrieves detailed information about a specific clinic by its ID.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved clinic details",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = Clinic.class))),
					@ApiResponse(responseCode = "404", description = "Clinic not found")
			}
	)
	@GetMapping("/{id}")
	public ResponseEntity<Clinic> getClinicById(
			@Parameter(description = "ID of the clinic to be retrieved", required = true, example = "1")
			@PathVariable("id") Long id)
	{
		Clinic clinic = clinicService.getClinicById(id);
		return ResponseEntity.ok(clinic);
	}

	// ...

	@Operation(
			summary = "Create a new clinic",
			description = "Creates a new clinic with the provided details.",
			responses = {
					@ApiResponse(responseCode = "201", description = "Clinic successfully created",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = Long.class))),
					@ApiResponse(responseCode = "400", description = "Invalid clinic details provided")
			}
	)
	@PostMapping
	public ResponseEntity<Long> createClinic(@RequestBody ClinicRequestDto clinicRequestDto)
	{
		Long createdClinicId = clinicService.createClinic(clinicRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdClinicId);
	}

	@Operation(
			summary = "Create a new clinic with all the specs",
			description = "Creates a new clinic and assigns the specified existing specifications to it.",
			responses = {
					@ApiResponse(responseCode = "201", description = "Clinic successfully created with specifications",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = Long.class))),
					@ApiResponse(responseCode = "400", description = "Invalid clinic or specifications details provided")
			}
	)
	@PostMapping("/specs")
	public ResponseEntity<Long> createClinicWithSpecs(@RequestBody ClinicSpecsRequestDto clinicSpecsRequestDto)
	{
		Long createdClinicId = clinicService.createClinicWithSpecs(clinicSpecsRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdClinicId);
	}

	@Operation(
			summary = "Assign medical service to clinic",
			description = "Assigns a specified medical service to a clinic.",
			responses = {
					@ApiResponse(responseCode = "201", description = "Medical service successfully assigned to the clinic"),
					@ApiResponse(responseCode = "400", description = "Invalid medical service details provided")
			}
	)
	@PostMapping("/assign-service")
	public ResponseEntity<Void> assignMedicalService(@RequestBody MedicalServiceRequestDto medicalService)
	{
		clinicService.assignMedicalService(medicalService);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Operation(
			summary = "Remove medical service from clinic",
			description = "Removes a specified medical service from a clinic.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Medical service successfully removed from the clinic"),
					@ApiResponse(responseCode = "404", description = "Clinic or medical service not found")
			}
	)
	@DeleteMapping("/remove-service/{clinicId}/{serviceId}")
	public ResponseEntity<Void> removeMedicalService(
			@Parameter(description = "ID of the clinic", required = true, example = "1") @PathVariable Long clinicId,
			@Parameter(description = "ID of the medical service", required = true, example = "1") @PathVariable Long serviceId)
	{
		clinicService.removeMedicalService(clinicId, serviceId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Operation(
			summary = "Assign oriental place to clinic",
			description = "Assigns an oriental place to a clinic.",
			responses = {
					@ApiResponse(responseCode = "201", description = "Oriental place successfully assigned to the clinic"),
					@ApiResponse(responseCode = "400", description = "Invalid oriental place details provided")
			}
	)
	@PostMapping("/assign-orient")
	public ResponseEntity<Void> assignOrientalPlace(@RequestBody OrientalPlaceDto orientalPlaceDto)
	{
		clinicService.assignOrient(orientalPlaceDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Operation(
			summary = "Remove oriental place from clinic",
			description = "Removes an oriental place from a clinic.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Oriental place successfully removed from the clinic"),
					@ApiResponse(responseCode = "404", description = "Clinic or oriental place not found")
			}
	)
	@DeleteMapping("/remove-orient/{clinicId}/{orientId}")
	public ResponseEntity<Void> removeOrientalPlace(
			@Parameter(description = "Clinic ID", required = true, example = "1") @PathVariable Long clinicId,
			@Parameter(description = "Oriental place ID", required = true, example = "1") @PathVariable Long orientId)
	{
		clinicService.removeOrient(clinicId, orientId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/speciality-count")
	public ResponseEntity<List<ClinicCountDto>> getClinicsSpecialitiesWithCount(){
		return ResponseEntity.ok(clinicService.getClinicsSpecialitiesWithCount());
	}

	@GetMapping("/clinics-count")
	public ResponseEntity<Long> getAllClinicsCount(){
		return ResponseEntity.ok(clinicService.getAllClinicsCount());
	}

	@GetMapping("/by-services")
	public ResponseEntity<List<ClinicCountDto>> getClinicsCountByServices(){
		return ResponseEntity.ok(clinicService.getClinicsByServices());
	}



}
