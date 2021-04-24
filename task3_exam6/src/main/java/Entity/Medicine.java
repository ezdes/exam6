package Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
@Entity
@Table(name = "medicine")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false)
    String name;
    @OneToOne
    @JoinColumn(name = "virus_id", referencedColumnName = "id")
    Virus virus;
}
