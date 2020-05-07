package stalterclouse.elspeth.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Objects;
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

    @Column(name = "practice_counter")
    private int practiceCounter;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private int zipCode;

    @Column(name = "longest_streak")
    private int longestStreak;

    // This OneToOne relationship is brought to you by a Baeldung tutorial at https://www.baeldung.com/jpa-one-to-one
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "user")
    private Role role;

    // Use of the OrderBy annotation was brought to my attention here: https://thoughts-on-java.org/ordering-vs-sorting-hibernate-use/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderBy("practice_date desc")
    private Set<PracticeLog> practiceLogs = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<PracticeHack> practiceHacks = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Studio> studios = new HashSet<>();

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<Instrument> instruments = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "user")
    private Instrument instrument;

    // This ManyToMany relationship is brought to you by this Mkyong tutorial: https://mkyong.com/hibernate/hibernate-many-to-many-relationship-example-annotation/
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "studentsInStudio")
    private Set<Studio> studiosOfStudent = new HashSet<>();

    public User(String username, String password, String firstName, String lastName, String email, int practiceCounter, LocalDate birthDate, String city, String state, int zipCode, int longestStreak) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.practiceCounter = practiceCounter;
        this.birthDate = birthDate;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.longestStreak = longestStreak;
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

    /**
     * Add practice hack.
     *
     * @param practiceHack the practice hack
     */
    public void addPracticeHack(PracticeHack practiceHack) {
        practiceHacks.add(practiceHack);
        practiceHack.setUser(this);
    }

    /**
     * Remove practice hack.
     *
     * @param practiceHack the practice hack
     */
    public void removePracticeHack(PracticeHack practiceHack) {
        practiceHacks.remove(practiceHack);
        practiceHack.setUser(null);
    }

//    /**
//     * Add instrument.
//     *
//     * @param instrument the instrument
//     */
//    public void addInstrument(Instrument instrument) {
//        instruments.add(instrument);
//        instrument.setUser(this);
//    }
//
//    /**
//     * Remove instrument.
//     *
//     * @param instrument the instrument
//     */
//    public void removeInstrument(Instrument instrument) {
//        instruments.remove(instrument);
//        instrument.setUser(null);
//    }


    /**
     * Add studio.
     *
     * @param studio the studio
     */
    public void addStudio(Studio studio) {
        studios.add(studio);
        studio.setTeacher(this);
    }

    /**
     * Remove studio.
     *
     * @param studio the studio
     */
    public void removeStudio(Studio studio) {
        studios.remove(studio);
        studio.setTeacher(null);
    }

}
