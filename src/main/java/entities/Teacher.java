package entities;

import lombok.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Check(constraints = "salary > 0")
@Table(name = "teacher")
public class Teacher {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;

    @NonNull
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NonNull
    @NaturalId
    @Column(name = "teacher_code", nullable = false)
    private String teacherCode;

    @NonNull
    @Column(name = "salary", nullable = false)
    private Double salary;

    @NonNull
    @Column(name = "bith_date",nullable = false)
    private LocalDate birthDay;


    @ManyToMany
    @JoinTable(name = "teacher_student",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<Student> students;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Address address;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCode='" + teacherCode + '\'' +
                ", salary=" + salary +
                ", birthDay=" + birthDay +
                ", students=" + getStudents() +
                ", address=" + address +
                '}';
    }
}
