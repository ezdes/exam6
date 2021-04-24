package Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
@Entity
@Table(name = "virus_medicine")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VirusMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "virus_id", referencedColumnName = "id")
    Virus virus;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    Medicine medicine;
}
