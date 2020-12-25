package entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id",unique = true,nullable = false)
    private Long id;


    @NonNull
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @NonNull
    @Column(name = "state", length = 30)
    private String state;

    @NonNull
    @Column(name = "city", length = 30)
    private String city;

    @NonNull
    @Column(name = "postal_address")
    private String postalAddress;

    @NonNull
    @Column(name = "postal_code", length = 10)
    private String postalCode;


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
