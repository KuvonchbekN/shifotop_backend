package uz.shifotop.api.address.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.address.dto.AddressRequestDto;
import uz.shifotop.api.address.entity.Address;
import uz.shifotop.api.address.service.AddressService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController
{
	private final AddressService addressService;


	@Operation(
			summary = "Get all addresses",
			description = "Retrieves a list of all addresses.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved all addresses",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = Address.class))),
					@ApiResponse(responseCode = "500", description = "Internal server error")
			}
	)
	@GetMapping
	public ResponseEntity<List<Address>> getAllAddresses()
	{
		return ResponseEntity.ok(addressService.getAllAddresses());
	}

	@Operation(
			summary = "Add a new address",
			description = "Adds a new address with the provided details.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Successfully added the address",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = Long.class))),
					@ApiResponse(responseCode = "400", description = "Invalid address details provided"),
					@ApiResponse(responseCode = "500", description = "Internal server error")
			}
	)
	@PostMapping
	public ResponseEntity<Long> addAddress(
			@Parameter(description = "Address details to be added", required = true)
			@RequestBody AddressRequestDto addressRequestDto)
	{
		return ResponseEntity.ok(addressService.saveAddress(addressRequestDto));
	}

}
