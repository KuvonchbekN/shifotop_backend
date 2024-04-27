package uz.shifotop.api.specialization.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import uz.shifotop.api.doctor.entity.Doctor;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialities")
public class Specialities { //this is actual singular

    @Id
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "specialities")
    @JsonBackReference
    private List<Doctor> doctors;
}
