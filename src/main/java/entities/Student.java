package entities;


import lombok.*;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @NonNull
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NonNull
    @NaturalId
    @Column(name = "student_code", nullable = false)
    private String studentCode;

    @NonNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDay;


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "student_address",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")} )
    Set<Address> addresses;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", birthDay=" + birthDay +
                ", addresses=" + getAddresses() +
                '}';
    }
}
