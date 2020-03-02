package stalterclouse.elspeth.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    // This ManyToMany relationship is brought to you by this Mkyong tutorial: https://mkyong.com/hibernate/hibernate-many-to-many-relationship-example-annotation/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "studio_students",
            joinColumns = { @JoinColumn(name = "studio_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "student_id", nullable = false, updatable = false) })
    private Set<User> studentsInStudio = new HashSet<>();

    public Studio(User teacher, String instrument) {

        this.teacher = teacher;
        this.instrument = instrument;
    }
}
