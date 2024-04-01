package uz.shifotop.api.clinic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.clinic.service.MedicalServiceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/services")
@Validated
@Slf4j
public class MedicalServicesController
{
	private final MedicalServiceService medicalServiceService;
	@GetMapping("/count")
	public ResponseEntity<Long> getServicesCount(){
		return ResponseEntity.ok(medicalServiceService.getMedicalServicesCount());
	}
}
