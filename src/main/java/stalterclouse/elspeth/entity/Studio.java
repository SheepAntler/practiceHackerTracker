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

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private int zipCode;

    // This ManyToMany relationship is brought to you by this Mkyong tutorial: https://mkyong.com/hibernate/hibernate-many-to-many-relationship-example-annotation/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) // Memo: I had to change this to PERSIST because deleting 1 user cascaded all the way around the circle and depleted most of my database
    @OrderBy("practice_counter desc")
    @JoinTable(name = "studio_students",
            joinColumns = { @JoinColumn(name = "studio_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "student_id", nullable = false, updatable = false) })
    private Set<User> studentsInStudio = new HashSet<>();

    public Studio(User teacher, String instrument, String organizationName, String streetAddress, String city, String state, int zipCode) {

        this.teacher = teacher;
        this.instrument = instrument;
        this.organizationName = organizationName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
