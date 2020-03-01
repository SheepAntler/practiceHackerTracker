//package stalterclouse.elspeth.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//
///**
// * Represents the Students in each Studio
// *
// * @author Elspeth Stalter-Clouse
// */
//@Data
//@NoArgsConstructor
//@Entity(name = "StudioStudent")
//@Table(name = "studio_students")
//public class StudioStudent {
//
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @ManyToOne
//    private Studio studio;
//
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @ManyToOne
//    private User student;
//
//    public StudioStudent(Studio studio, User student) {
//
//        this.studio = studio;
//        this.student = student;
//    }
//
//}
