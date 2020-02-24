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

class PracticeLogDaoTest {

    GenericDao genericDao;

    /**
     * Creating the DAO
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(PracticeLog.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void returnAllLogsSuccess() {
        List<PracticeLog> logs = genericDao.getAllEntities();
        assertEquals(5, logs.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        PracticeLog retrievedLog = (PracticeLog)genericDao.getById(4);
        assertEquals(4, retrievedLog.getId());
    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertSuccess() {

        // Log data
        GenericDao genericUser = new GenericDao(User.class);
        User user = (User)genericUser.getById(5);
        LocalDate practiceDate = LocalDate.of(2020, 2, 14);
        LocalDateTime start = practiceDate.atTime(1, 50, 00);
        LocalDateTime end = practiceDate.atTime(2, 50, 00);
        String activities = "Tra La La!";
        String notes = "Do be do be do.";
        String teacher_comments = "Yahoo!";

        PracticeLog newLog = new PracticeLog(user, practiceDate, start, end, activities, notes, teacher_comments);

        int id = genericDao.insert(newLog);
        assertNotEquals(0,id);
        PracticeLog insertedLog = (PracticeLog)genericDao.getById(id);
        assertEquals(newLog, insertedLog);
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
        LocalDate date = LocalDate.of(2019, 12, 25);
        List<PracticeLog> logs = genericDao.getByPropertyEqual("notes", "Nat's Knapsack Strap Snapped");
        assertEquals(1, logs.size());
        assertEquals(2, logs.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<PracticeLog> logs = genericDao.getByPropertyLike("activities", "scales");
        assertEquals(4, logs.size());
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newActivities = "I ate cake";
        PracticeLog logToUpdate = (PracticeLog)genericDao.getById(4);
        logToUpdate.setActivities(newActivities);
        genericDao.saveOrUpdate(logToUpdate);
        PracticeLog retrievedLog = (PracticeLog)genericDao.getById(4);
        assertEquals(newActivities, retrievedLog.getActivities());
    }
}