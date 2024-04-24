package uz.shifotop.api.clinic.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.address.entity.Address;
import uz.shifotop.api.clinicSpecs.entity.ClinicSpec;
import uz.shifotop.api.doctor.entity.Doctor;
import uz.shifotop.api.user.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "official_name")
    private String officialName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "supervisor_name")
    private String supervisorName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "clinic_user", joinColumns = @JoinColumn(name = "clinic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users; //mighty clients

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "clinic_doctor", joinColumns = @JoinColumn(name = "clinic_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private Set<Doctor> doctors;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MedicalService> medicalServices = new ArrayList<>();

    @OneToMany(mappedBy = "clinicIdForOrientalPlace", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //all orientalPlaces should be removed, when clinic is deleted
    private List<Address> orientalPlaces = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "clinic_spec_aux", joinColumns = @JoinColumn(name = "clinic_id"),
            inverseJoinColumns = @JoinColumn(name = "spec_id"))
    private Set<ClinicSpec> clinicSpecs;


    //these methods are needed for correct synchronization
    public void addMedicalService(MedicalService medicalService) {
        medicalServices.add(medicalService);
        medicalService.setClinic(this);
    }

    public void removeMedicalService(MedicalService medicalService) {
        medicalServices.remove(medicalService);
        medicalService.setClinic(null);
    }

    public void addOrientalPlace(Address orientalPlace) {
        orientalPlaces.add(orientalPlace);
        orientalPlace.setClinicIdForOrientalPlace(this);
    }

    public void removeOrientalPlace(Address orientalPlace) {
        orientalPlaces.remove(orientalPlace);
        orientalPlace.setClinicIdForOrientalPlace(null);
    }
}