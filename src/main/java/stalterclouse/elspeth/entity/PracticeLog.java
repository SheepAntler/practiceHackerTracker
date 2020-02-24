package stalterclouse.elspeth.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import stalterclouse.elspeth.entity.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a practice log entry
 *
 * @author Elspeth Stalter-Clouse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PracticeLog")
@Table(name = "practice_logs")
public class PracticeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "practice_date")
    private LocalDate practiceDate;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "activities")
    private String activities;

    @Column(name = "notes")
    private String notes;

    @Column(name = "teacher_comments")
    private String teacherComments;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private User user;

    public PracticeLog(User user, LocalDate practiceDate, LocalDateTime startTime, LocalDateTime endTime, String activities, String notes, String teacherComments) {
        this.user = user;
        this.practiceDate = practiceDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activities = activities;
        this.notes = notes;
        this.teacherComments = teacherComments;
    }
}