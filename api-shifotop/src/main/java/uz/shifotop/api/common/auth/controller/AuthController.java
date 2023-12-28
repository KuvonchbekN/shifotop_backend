package uz.shifotop.api.common.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.common.auth.dto.AuthResponse;
import uz.shifotop.api.common.auth.dto.LoginDto;
import uz.shifotop.api.common.auth.dto.RegisterRequest;
import uz.shifotop.api.common.auth.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController
{

	private final AuthService authService;

	@Operation(
			summary = "User registration",
			description = "Registers a new user with the provided details.",
			responses = {
					@ApiResponse(responseCode = "200", description = "User successfully registered",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = AuthResponse.class))),
					@ApiResponse(responseCode = "400", description = "Invalid registration details provided")
			}
	)
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(
			@Parameter(description = "User registration details", required = true)
			@RequestBody RegisterRequest dto)
	{
		return ResponseEntity.ok(authService.register(dto));
	}

	@Operation(
			summary = "User login",
			description = "Logs in a user with the provided credentials.",
			responses = {
					@ApiResponse(responseCode = "200", description = "User successfully logged in",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = AuthResponse.class))),
					@ApiResponse(responseCode = "401", description = "Unauthorized - Invalid login credentials")
			}
	)
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(
			@Parameter(description = "User login credentials", required = true)
			@RequestBody LoginDto dto)
	{
		return ResponseEntity.ok(authService.login(dto));
	}

	@Operation(
			summary = "Refresh access token",
			description = "Refreshes the access token using the refresh token provided in the request.",
			responses = {
					@ApiResponse(responseCode = "200", description = "Access token successfully refreshed",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = AuthResponse.class))),
					@ApiResponse(responseCode = "401", description = "Unauthorized - Invalid or expired refresh token")
			}
	)
	@PostMapping("/refresh-token")
	public ResponseEntity<AuthResponse> refreshToken(
			@Parameter(description = "HttpServletRequest containing the refresh token", hidden = true)
			HttpServletRequest request,
			@Parameter(description = "HttpServletResponse for returning the new access token", hidden = true)
			HttpServletResponse response)
	{
		return ResponseEntity.ok(authService.refreshToken(request, response));
	}

}
