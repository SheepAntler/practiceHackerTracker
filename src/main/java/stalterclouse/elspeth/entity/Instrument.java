package stalterclouse.elspeth.entity;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Represents an Instrument
 *
 * @author Elspeth Stalter-Clouse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Entity(name = "Instrument")
@Table(name = "instruments")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private User user;

    @Column(name = "instrument")
    private String instrument;

    public Instrument(User user, String instrument) {

        this.user = user;
        this.instrument = instrument;
    }



}
