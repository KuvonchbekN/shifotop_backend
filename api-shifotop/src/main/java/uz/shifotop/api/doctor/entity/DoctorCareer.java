package uz.shifotop.api.doctor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.doctor.enums.DoctorCareerType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor_career")
public class DoctorCareer {

    @Id
    private Long id;
    @Column(name = "careerName")
    private String careerName;
    @Column(name = "career_role")
    private String careerRole;
    @Column(name = "career_date")
    private String careerDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "doctor_career_type")
    private DoctorCareerType doctorCareerType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

}
