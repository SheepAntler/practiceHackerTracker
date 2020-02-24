package stalterclouse.elspeth.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Represents a Practice Hack entry
 *
 * @author Elspeth Stalter-Clouse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PracticeHack")
@Table(name = "practice_hacks")
public class PracticeHack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "skill_level")
    private String skillLevel;

    @Column(name = "text_body")
    private String practiceHack;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private User user;

    public PracticeHack(User user, String skillLevel, String practiceHack) {
        this.user = user;
        this.skillLevel = skillLevel;
        this.practiceHack = practiceHack;
    }
}
