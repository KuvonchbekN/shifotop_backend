package uz.shifotop.api.doctor.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.specialization.entity.Specialities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<DoctorCareer> careerList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "doctor_specialities",
            joinColumns = { @JoinColumn(name = "doctor_id") },
            inverseJoinColumns = { @JoinColumn(name = "speciality_id") }
    )
    private Set<Specialities> specialities;

    @ManyToMany(mappedBy = "doctors",fetch = FetchType.LAZY)
    private Set<Clinic> clinics;

}
