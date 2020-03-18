package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.PracticeLog;
import stalterclouse.elspeth.entity.Studio;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.utilities.Database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudioDaoTest {

    GenericDao genericDao;

    /**
     * Creating the DAO
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Studio.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void returnAllLogsSuccess() {
        List<Studio> studios = genericDao.getAllEntities();
        assertEquals(5, studios.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        Studio retrievedStudio = (Studio)genericDao.getById(4);
        assertEquals(4, retrievedStudio.getId());
    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertSuccess() {

        // Log data
        GenericDao genericUser = new GenericDao(User.class);
        User user = (User) genericUser.getById(5);

        Studio newStudio = new Studio(user, "flute", null, "2742 Jacque St.", "Iowa City", "IA", 52246);

        int id = genericDao.insert(newStudio);
        assertNotEquals(0, id);
        Studio insertedStudio = (Studio) genericDao.getById(id);
        assertEquals(newStudio, insertedStudio);
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
        List<Studio> studios = genericDao.getByPropertyEqual("teacher", 5);
        assertEquals(1, studios.size());
        assertEquals(2, studios.get(0).getId());
    }

    /**
     * Verify successful get by property (approximate match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Studio> studios = genericDao.getByPropertyLike("instrument", "viol");
        assertEquals(2, studios.size());
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        GenericDao genericUser = new GenericDao(User.class);
        User newTeacher = (User)genericUser.getById(3);
        Studio studioToUpdate = (Studio)genericDao.getById(4);
        studioToUpdate.setTeacher(newTeacher);
        genericDao.saveOrUpdate(studioToUpdate);
        Studio retrievedStudio = (Studio)genericDao.getById(4);
        assertEquals(newTeacher, retrievedStudio.getTeacher());
    }

    /**
     * Verifies that the User/Studio bridging table is working correctly
     */
    @Test
    void testStudioStudentsConnection() {
        Studio studio = (Studio)genericDao.getById(5);

        assertEquals(2, studio.getStudentsInStudio().size());
    }

}