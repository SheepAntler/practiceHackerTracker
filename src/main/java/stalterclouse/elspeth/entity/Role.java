package stalterclouse.elspeth.entity;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents User Role
 *
 * @author Elspeth Stalter-Clouse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Entity(name = "Role")
@Table(name = "user_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // This OneToOne relationship is brought to you by a Baeldung tutorial at https://www.baeldung.com/jpa-one-to-one
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "username")
    private String username;

    @Column(name = "role_name")
    private String role;

    /**
     * Instantiates a new Role.
     *
     * @param role the role
     */
    public Role(User user, String username, String role) {
        this.user = user;
        this.username = username;
        this.role = role;
    }
}
