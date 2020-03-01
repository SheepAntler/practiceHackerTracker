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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "studio_students",
            joinColumns = { @JoinColumn(name = "studio_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "student_id", nullable = false, updatable = false) })
    private Set<User> studentsInStudio = new HashSet<>();

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<StudioStudent> studioStudents = new HashSet<>();

    public Studio(User teacher, String instrument) {

        this.teacher = teacher;
        this.instrument = instrument;
    }
//
//    /**
//     * Add student to studio.
//     *
//     * @param studioStudent the student in the studio
//     */
//    public void addStudioToStudent(StudioStudent studioStudent) {
//        studioStudents.add(studioStudent);
//        studioStudent.setStudio(this);
//    }
//
//    /**
//     * Remove student from studio.
//     *
//     * @param studioStudent the student in the studio
//     */
//    public void removeStudioFromStudent(StudioStudent studioStudent) {
//        studioStudents.remove(studioStudent);
//        studioStudent.setStudio(null);
//    }
}
