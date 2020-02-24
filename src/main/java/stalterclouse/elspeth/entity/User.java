package stalterclouse.elspeth.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a User
 *
 * @author Elspeth Stalter-Clouse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "username")
    @NaturalId
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "instrument")
    private String instrument;

    @Column(name = "skill_level")
    private String skillLevel;

    @Column(name = "practice_counter")
    private int practiceCounter;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "studio_size")
    private int studioSize;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @ManyToOne
//    private Role role;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<PracticeLog> practiceLogs = new HashSet<>();


    public User(String username, String password, String firstName, String lastName, String email, String instrument, String skillLevel, int practiceCounter, LocalDate birthDate, int studioSize) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instrument = instrument;
        this.skillLevel = skillLevel;
        this.practiceCounter = practiceCounter;
        this.birthDate = birthDate;
        this.studioSize = studioSize;
    }

    /**
     * Calculates a user's age based on their date of birth
     *
     * @return the user's age
     */
    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    /**
     * Add practice log.
     *
     * @param log the log
     */
    public void addPracticeLog(PracticeLog log) {
        practiceLogs.add(log);
        log.setUser(this);
    }

    /**
     * Remove practice log.
     *
     * @param log the log
     */
    public void removePracticeLog(PracticeLog log) {
        practiceLogs.remove(log);
        log.setUser(null);
    }

}
