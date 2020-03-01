package stalterclouse.elspeth.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Represents a studio
 *
 * @author Elspeth Stalter-Clouse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Studio")
@Table(name = "studios")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private User teacher;

    @Column(name = "instrument")
    private String instrument;

    public Studio(User teacher, String instrument) {

        this.teacher = teacher;
        this.instrument = instrument;
    }
}
