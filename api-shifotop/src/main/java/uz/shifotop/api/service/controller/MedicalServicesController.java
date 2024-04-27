package uz.shifotop.api.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.service.dto.MedicalServiceResponseDto;
import uz.shifotop.api.service.entity.MedicalService;
import uz.shifotop.api.service.service.MedicalServiceService;

import java.util.List;

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

	@GetMapping
	public ResponseEntity<List<MedicalService>> getMedicalServices(){ //todo endpoint buggy => maybe change it to responseDto type
		return ResponseEntity.ok(medicalServiceService.getAllMedicalServices());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MedicalServiceResponseDto> getMedicalServiceById(@PathVariable Long id){
		return ResponseEntity.ok(medicalServiceService.getMedicalServiceById(id));
	}

	@GetMapping("/type/{type}")
	public ResponseEntity<List<MedicalService>> getMedicalServicesByType(@PathVariable String type){
		return ResponseEntity.ok(medicalServiceService.getAllMedicalServicesByName(type));
	}
}
