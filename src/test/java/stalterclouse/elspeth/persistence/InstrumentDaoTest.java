package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.Instrument;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.utilities.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentDaoTest {

    GenericDao genericDao;

    /**
     * Creating the DAO
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Instrument.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verifies gets all instruments successfully.
     */
    @Test
    void returnAllInstrumentsSuccess() {
        List<Instrument> instruments = genericDao.getAllEntities();
        assertEquals(5, instruments.size());
    }

    /**
     * Verify successful retrieval of an instrument
     */
    @Test
    void getByIdSuccess() {
        Instrument retrievedInstrument = (Instrument)genericDao.getById(4);
        assertEquals(4, retrievedInstrument.getId());
    }

    /**
     * Verifies successful insert of an instrument
     */
    @Test
    void insertSuccess() {

        // Log data
        GenericDao genericUser = new GenericDao(User.class);
        User user = (User)genericUser.getById(5);
        String instrument = "bagpipes";
        String skillLevel = "expert";

        Instrument newInstrument = new Instrument(user, instrument, skillLevel);

        int id = genericDao.insert(newInstrument);
        assertNotEquals(0,id);
        Instrument insertedInstrument = (Instrument)genericDao.getById(id);
        assertEquals(newInstrument, insertedInstrument);
    }

    /**
     * Verify successful delete of an instrument
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
        List<Instrument> instruments = genericDao.getByPropertyEqual("instrument", "cello");
        assertEquals(1, instruments.size());
        assertEquals(5, instruments.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Instrument> instruments = genericDao.getByPropertyLike("instrument", "cell");
        assertEquals(1, instruments.size());
    }

    /**
     * Verify successful update of instrument
     */
    @Test
    void updateSuccess() {
        String newInstrument = "crumhorn";
        Instrument instrumentToUpdate = (Instrument)genericDao.getById(1);
        instrumentToUpdate.setInstrument(newInstrument);
        genericDao.saveOrUpdate(instrumentToUpdate);
        Instrument retrievedInstrument = (Instrument)genericDao.getById(1);
        assertEquals(newInstrument, retrievedInstrument.getInstrument());
    }
}