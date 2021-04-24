package Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
@Entity
@Table(name = "virus")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Virus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false)
    String name;
}
