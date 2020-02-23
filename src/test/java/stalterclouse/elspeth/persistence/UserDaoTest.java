package stalterclouse.elspeth.persistence;

import stalterclouse.elspeth.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    /**
     * Creating the DAO
     */
    @BeforeEach
    void setUp() {

        dao = new UserDao();

        stalterclouse.elspeth.utilities.Database database = stalterclouse.elspeth.utilities.Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void returnAllUsersSuccess() {
        List<User> users = dao.returnAllUsers();
        assertEquals(5, users.size());
    }

    /**
     * Verifies gets users by username successfully.
     */
    @Test
    void findUsersByUsernameSuccess() {
        List<User> users = dao.findUsersByUsername("f");
        assertEquals(1, users.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(4);
        assertEquals(4, retrievedUser.getId());
        assertEquals("GeezLouise", retrievedUser.getUsername());
        assertEquals("password", retrievedUser.getPassword());
        assertEquals("Louise", retrievedUser.getFirstName());
        assertEquals("Janak", retrievedUser.getLastName());
        assertEquals("flugelhorn", retrievedUser.getInstrument());
        assertEquals("advanced", retrievedUser.getSkillLevel());
        assertEquals(44, retrievedUser.getPracticeCounter());
        assertEquals("2002-06-04", (retrievedUser.getBirthDate()).toString());
        assertEquals(1, retrievedUser.getStudioSize());
    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("brandNew", "password", "Brad", "News", "bnews@gmail.com", "percussion", "beginner", 42, LocalDate.parse("1998-01-01"), 0);
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(5, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyEqual("instrument", "flugelhorn");
        assertEquals(1, users.size());
        assertEquals(4, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("username", "s");
        assertEquals(4, users.size());
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        User userToUpdate = dao.getById(4);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(4);
        assertEquals(newLastName, retrievedUser.getLastName());
    }
}