package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.PracticeHack;
import stalterclouse.elspeth.entity.PracticeLog;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.utilities.Database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PracticeHackDaoTest {

    GenericDao genericDao;

    /**
     * Creating the DAO
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(PracticeHack.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void returnAllLogsSuccess() {
        List<PracticeHack> hacks = genericDao.getAllEntities();
        assertEquals(5, hacks.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        PracticeHack retrievedHack = (PracticeHack)genericDao.getById(4);
        assertEquals(4, retrievedHack.getId());
    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertSuccess() {

        // Log data
        GenericDao genericUser = new GenericDao(User.class);
        User user = (User)genericUser.getById(5);
        String skillLevel = "intermediate";
        String instrument = "viola";
        String practiceHack = "Unpack, you hack!";

        PracticeHack newHack = new PracticeHack(user, skillLevel, instrument, practiceHack);

        int id = genericDao.insert(newHack);
        assertNotEquals(0,id);
        PracticeHack insertedHack = (PracticeHack)genericDao.getById(id);
        assertEquals(newHack, insertedHack);
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
        List<PracticeHack> hacks = genericDao.getByPropertyEqual("skillLevel", "intermediate");
        assertEquals(1, hacks.size());
        assertEquals(1, hacks.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<PracticeHack> hacks = genericDao.getByPropertyLike("instrument", "viol");
        assertEquals(2, hacks.size());
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newHack = "play arpeggios for 20 minutes";
        PracticeHack hackToUpdate = (PracticeHack)genericDao.getById(1);
        hackToUpdate.setPracticeHack(newHack);
        genericDao.saveOrUpdate(hackToUpdate);
        PracticeHack retrievedHack = (PracticeHack)genericDao.getById(1);
        assertEquals(newHack, retrievedHack.getPracticeHack());
    }
}