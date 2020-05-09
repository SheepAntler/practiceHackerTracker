package stalterclouse.elspeth.persistence;

import stalterclouse.elspeth.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.utilities.Database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        LocalDate birthDate = LocalDate.of(2002, 06, 04);
        User expectedUser = new User("GeezLouise", "password", "Louise", "Janak", "yesitiscalledaflugelhorn@gmail.com", 44, birthDate, "Madison", "WI", 53703, 12);
        expectedUser.setId(4);
        User retrievedUser = (User)genericDao.getById(4);
        assertEquals(expectedUser, retrievedUser);
    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("brandNew", "password", "Brad", "News", "bnews@gmail.com", 42, LocalDate.parse("1998-01-01"), "Portland", "OR", 97035, 100);
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verifies successful insert of a user with a practice log entry
     */
    @Test
    void insertWithLogSuccess() {

        User newUser = new User("brandNew", "password", "Brad", "News", "bnews@gmail.com", 42, LocalDate.parse("1998-01-01"), "Portland", "OR", 97035, 100);

        // Practice Log data
        LocalDateTime insertablePracticeDate = LocalDateTime.now();
        LocalDate practiceDate = LocalDate.now();
        LocalDateTime start = practiceDate.atTime(1, 50, 00);
        LocalDateTime end = practiceDate.atTime(2, 50, 00);
        String activities = "Tra La La!";
        String notes = "Do be do be do.";
        String teacher_comments = "Yahoo!";

        PracticeLog log = new PracticeLog(newUser, insertablePracticeDate, start, end, activities, notes, teacher_comments);

        newUser.addPracticeLog(log);

        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getPracticeLogs().size());
    }

    /**
     * Verifies successful insert of a user with a practice hack entry
     */
    @Test
    void insertWithHackSuccess() {

        User newUser = new User("brandNew", "password", "Brad", "News", "bnews@gmail.com", 42, LocalDate.parse("1998-01-01"), "Portland", "OR", 97035, 100);

        // Practice Hack data
        String skillLevel = "advanced";
        String instrument = "cello";
        String practiceHack = "Just, like, get it out of the case, dude.";

        PracticeHack entry = new PracticeHack(newUser, skillLevel, instrument, practiceHack);

        newUser.addPracticeHack(entry);

        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getPracticeHacks().size());
    }

    /**
     * Verifies successful insert of a user with an associated studio
     */
    @Test
    void insertWithStudioSuccess() {
        User newUser = new User("brandNew", "password", "Brad", "News", "bnews@gmail.com", 42, LocalDate.parse("1998-01-01"), "Portland", "OR", 97035, 100);
        Studio studio = new Studio(newUser, "oboe", "UW-Madison", "UW Street Address", "Madison", "WI", 53705);

        newUser.addStudio(studio);

        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getStudios().size());

    }

    /**
     * Verify successful delete of a user
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
        List<User> users = genericDao.getByPropertyEqual("email", "yesitiscalledaflugelhorn@gmail.com");
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
     * Verify successful update of a user
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

    /**
     * Verifies that the User/Studio bridging table is working correctly for students
     */
    @Test
    void testStudioStudentsConnection() {
        User student = (User)genericDao.getById(3);

        assertEquals(2, student.getStudiosOfStudent().size());
    }

    /**
     * Verifies that the User/Studio bridging table is working correctly for teachers
     */
    @Test
    void testStudioConnection() {
        User teacher = (User)genericDao.getById(1);

        assertEquals(2, teacher.getStudios().size());
    }

    /**
     * Verifies that the User/Role relationship is established correctly
     */
    @Test
    void testUserRoleRetrieval() {
        User studentUser = (User)genericDao.getById(1);
        User teacherUser = (User)genericDao.getById(2);
        User practiceHackerUser = (User)genericDao.getById(3);

        Role student = studentUser.getRole();
        Role teacher = teacherUser.getRole();
        Role practiceHacker = practiceHackerUser.getRole();

        assertEquals("student", student.getRole());
        assertEquals("teacher", teacher.getRole());
        assertEquals("practiceHacker", practiceHacker.getRole());
    }

    /**
     * Verifies that the User/Instrument relationship is established correctly
     */
    @Test
    void testUserInstrumentRetrieval() {
        User testUser = (User)genericDao.getById(3);

        Instrument userInstrument = testUser.getInstrument();

        assertEquals("violin", userInstrument.getInstrument());
        assertEquals("professional", userInstrument.getSkillLevel());
    }

    /**
     * Verifies that updating a user can update the user's instrument
     */
    @Test
    void testUpdateUserInstrument() {
        User testUser = (User)genericDao.getById(5);

        testUser.getInstrument().setSkillLevel("beginner");

        genericDao.saveOrUpdate(testUser);

        assertEquals("beginner", testUser.getInstrument().getSkillLevel());

    }

    /**
     * Verifies that I can get a user by a map of properties
     */
    @Test
    void testGetByPropertiesEqual() {
        Map<String, Object> propertyMap = new HashMap<String, Object>();

        propertyMap.put("firstName", "Elaine");
        propertyMap.put("practiceCounter", 12);

        List<User> returnedUsers = genericDao.getByPropertiesEqual(propertyMap);

        assertEquals(1, returnedUsers.size());
    }

}