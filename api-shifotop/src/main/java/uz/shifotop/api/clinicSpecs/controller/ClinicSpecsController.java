package uz.shifotop.api.clinicSpecs.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.clinicSpecs.dto.ClinicSpecCreateDto;
import uz.shifotop.api.clinicSpecs.entity.ClinicSpec;
import uz.shifotop.api.clinicSpecs.service.ClinicSpecsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clinic-spec")
@RequiredArgsConstructor
public class ClinicSpecsController
{

	private final ClinicSpecsService clinicSpecsService;

	@Operation(
			summary = "Create a new clinic specification",
			description = "Creates a new clinic specification with the provided details.",
			responses = {
					@ApiResponse(responseCode = "201", description = "Clinic specification successfully created",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = Long.class))),
					@ApiResponse(responseCode = "400", description = "Invalid clinic specification details provided")
			}
	)
	@PostMapping
	public ResponseEntity<Long> createClinicSpec(
			@Parameter(description = "Clinic specification details to be added", required = true)
			@RequestBody ClinicSpecCreateDto clinicSpecCreateDto)
	{
		Long clinicSpecId = clinicSpecsService.createClinicSpec(clinicSpecCreateDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(clinicSpecId);
	}

	@Operation(
			summary = "Get all clinic specifications",
			description = "Retrieves a list of all clinic specifications.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved all clinic specifications",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ClinicSpec.class))),
					@ApiResponse(responseCode = "500", description = "Internal server error")
			}
	)
	@GetMapping
	public ResponseEntity<List<ClinicSpec>> getClinicSpecsList()
	{
		return ResponseEntity.ok(clinicSpecsService.getClinicSpecsList());
	}

	@Operation(
			summary = "Get clinic specifications by clinic ID",
			description = "Retrieves a list of clinic specifications for a specific clinic by its ID.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved clinic specifications for the given clinic",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = ClinicSpec.class))),
					@ApiResponse(responseCode = "404", description = "Clinic not found")
			}
	)
	@GetMapping("/{clinicId}")
	public ResponseEntity<List<ClinicSpec>> getClinicSpecsByClinicId(
			@Parameter(description = "ID of the clinic to retrieve specifications for", required = true, example = "1")
			@PathVariable Long clinicId)
	{
		List<ClinicSpec> clinicSpecsByClinicId = clinicSpecsService.getClinicSpecsByClinicId(clinicId);
		return ResponseEntity.ok(clinicSpecsByClinicId);
	}
}
