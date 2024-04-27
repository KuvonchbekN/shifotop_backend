package uz.shifotop.api.service.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.clinic.entity.Clinic;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medical_service")
public class MedicalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal cost;//in soums

    @ManyToMany(mappedBy = "medicalServices", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Clinic> clinics = new HashSet<>();
}
