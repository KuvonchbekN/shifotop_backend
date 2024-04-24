package uz.shifotop.api.review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.clinic.entity.Clinic;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.user.entity.User;

import java.time.LocalDateTime;


@Entity
@Table(name = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private User patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id") //if clinic is null
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "clinic_id") //if doctor is null
    private Clinic clinic;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "content")
    private String content;

    @Column(name = "review_date")
    private LocalDateTime reviewDate;
}
