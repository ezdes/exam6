package Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import Enum.Gender;
@Entity
@Table(name = "student")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "average_mark", nullable = false)
    Double averageMark;
    @Column(name = "age", nullable = false)
    Integer age;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    Gender gender;
}
