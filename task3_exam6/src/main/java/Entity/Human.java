package Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import Enum.Gender;
@Entity
@Table(name = "human")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "full_name", nullable = false)
    String fullName;
    @Column(name = "age", nullable = false)
    Integer age;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    Gender gender;
    @OneToOne
    @JoinColumn(name = "virus_id", referencedColumnName = "id")
    Virus virus;
}
