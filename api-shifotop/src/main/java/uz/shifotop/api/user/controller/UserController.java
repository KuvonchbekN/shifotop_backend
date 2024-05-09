package uz.shifotop.api.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.user.dto.UserCreateDto;
import uz.shifotop.api.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController
{


	private final ApplicationContext context;

	@Operation(
			summary = "Create a new user",
			description = "Creates a new user with the provided details. The user role determines the specific user service to use for creation.",
			responses = {
					@ApiResponse(responseCode = "200", description = "User successfully created and user ID returned",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = Long.class))),
					@ApiResponse(responseCode = "400", description = "Invalid user details provided"),
					@ApiResponse(responseCode = "500", description = "Internal server error or role-related service issue")
			}
	)
	@PostMapping
	public ResponseEntity<Long> createUser(
			@Parameter(description = "User creation details", required = true)
			@RequestBody UserCreateDto userCreateDto)
	{
		//todo there is a problem in this part, cannot add the user => maybe that is because user is not usually added,
		// but they register, doctors are added but we as developers add them.
		String serviceName = getServiceName(userCreateDto.role());
		UserService selectedService = context.getBean(serviceName, UserService.class);
		Long userId = selectedService.createUser(userCreateDto);
		System.out.println("This user ID is " + userId);
		return ResponseEntity.ok(userId);
	}

	private String getServiceName(String role)
	{
		return role.toLowerCase() + "ServiceImpl";
	}
}
