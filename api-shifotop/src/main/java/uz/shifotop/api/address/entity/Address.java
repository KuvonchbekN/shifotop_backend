package uz.shifotop.api.address.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.shifotop.api.clinic.entity.Clinic;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "address_name")
    private String addressName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Clinic clinicIdForOrientalPlace;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    @JsonManagedReference
    private Clinic clinic;
}
