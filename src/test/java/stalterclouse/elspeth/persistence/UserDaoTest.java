package stalterclouse.elspeth.persistence;

import stalterclouse.elspeth.entity.PracticeLog;
import stalterclouse.elspeth.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.utilities.Database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao genericDao;

    /**
     * Creating the DAO
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void returnAllUsersSuccess() {
        List<User> users = genericDao.getAllEntities();
        assertEquals(5, users.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(4);
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
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertWithLogSuccess() {

        User newUser = new User("brandNew", "password", "Brad", "News", "bnews@gmail.com", "percussion", "beginner", 42, LocalDate.parse("1998-01-01"), 0);

        // Log data
        LocalDate practiceDate = LocalDate.of(2020, 2, 14);
        LocalDateTime start = practiceDate.atTime(1, 50, 00);
        LocalDateTime end = practiceDate.atTime(2, 50, 00);
        String activities = "Tra La La!";
        String notes = "Do be do be do.";
        String teacher_comments = "Yahoo!";

        PracticeLog log = new PracticeLog(newUser, practiceDate, start, end, activities, notes, teacher_comments);

        newUser.addPracticeLog(log);

        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getPracticeLogs().size());
    }

    /**
     * Verify successful delete of user
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
        List<User> users = genericDao.getByPropertyEqual("instrument", "flugelhorn");
        assertEquals(1, users.size());
        assertEquals(4, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("username", "s");
        assertEquals(4, users.size());
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        User userToUpdate = (User)genericDao.getById(4);
        userToUpdate.setLastName(newLastName);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)genericDao.getById(4);
        assertEquals(newLastName, retrievedUser.getLastName());
    }
}