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
@Entity(name = "Roles")
@Table(name = "user_roles")
public class Role {
    @Column(name = "role_name")
    private String role;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany//(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="username")
    private Set<User> users = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * Instantiates a new Role.
     *
     * @param role the role
     */
    public Role(String role) {
        this.role = role;
    }
}
