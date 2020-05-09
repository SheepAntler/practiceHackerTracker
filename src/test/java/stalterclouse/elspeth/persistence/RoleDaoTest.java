package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.Role;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.utilities.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    GenericDao genericDao;

    /**
     * Creating the DAO
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Role.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all roles successfully.
     */
    @Test
    void returnAllHacksSuccess() {
        List<Role> roles = genericDao.getAllEntities();
        assertEquals(4, roles.size());
    }

    /**
     * Verify successful retrieval of a role
     */
    @Test
    void getByIdSuccess() {
        Role retrievedRole = (Role)genericDao.getById(4);
        assertEquals(4, retrievedRole.getId());
    }

    /**
     * Verifies successful insert of a role
     */
    @Test
    void insertSuccess() {

        // Log data
        GenericDao genericUser = new GenericDao(User.class);
        User user = (User)genericUser.getById(5);
        String role = "practiceHacker";

        Role newRole = new Role(user, user.getUsername(), role);

        int id = genericDao.insert(newRole);
        assertNotEquals(0,id);
        Role insertedRole = (Role)genericDao.getById(id);
        assertEquals(newRole, insertedRole);
    }

    /**
     * Verify successful delete of a role
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Role> roles = genericDao.getByPropertyEqual("username", "fluffybunny");
        assertEquals(1, roles.size());
        assertEquals(1, roles.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Role> roles = genericDao.getByPropertyLike("username", "fluff");
        assertEquals(1, roles.size());
    }

    /**
     * Verify successful update of a role
     */
    @Test
    void updateSuccess() {
        String newRole = "practiceHacker";
        Role roleToUpdate = (Role)genericDao.getById(1);
        roleToUpdate.setRole(newRole);
        genericDao.saveOrUpdate(roleToUpdate);
        Role retrievedRole = (Role)genericDao.getById(1);
        assertEquals(newRole, retrievedRole.getRole());
    }
}