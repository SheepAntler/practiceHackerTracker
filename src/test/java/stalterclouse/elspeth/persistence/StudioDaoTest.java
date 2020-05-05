package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.PracticeLog;
import stalterclouse.elspeth.entity.Studio;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.utilities.Database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    /**
     * Verifies that I can get a student's teacher ID
     * ArrayList conversion assistance from https://beginnersbook.com/2014/08/convert-hashset-to-a-list-arraylist/
     */
    @Test
    void testStudentTeacherConnection() {
        GenericDao genericUser = new GenericDao(User.class);
        User student = (User)genericUser.getById(1);

        List<Studio> studioArrayList = new ArrayList<Studio>(student.getStudiosOfStudent());
        Studio studio = studioArrayList.get(0);
        User teacher = studio.getTeacher();

        assertEquals(1, teacher.getId());

    }

    /**
     * Verifies that I can get a teacher's students' practice counts
     */
    @Test
    void testStudentPracticeCounters() {
        GenericDao genericTeacher = new GenericDao(User.class);
        User teacher = (User)genericTeacher.getById(1);

        List<Studio> studioArrayList = new ArrayList<Studio>(teacher.getStudios());
        Studio studio = studioArrayList.get(0);
        List<User> studentsInStudio = new ArrayList<User>(studio.getStudentsInStudio());

        User firstStudent = studentsInStudio.get(0);

        assertEquals(28, firstStudent.getPracticeCounter());
    }

    /**
     * Verifies that I can add a student to a studio
     */
    @Test
    void testAddStudent() {
        GenericDao genericUser = new GenericDao(User.class);
        User user = (User) genericUser.getById(5);

        Studio additionalStudio = (Studio)genericDao.getById(4);

        Set<User> studioStudents = additionalStudio.getStudentsInStudio();

        studioStudents.add(user);

        genericDao.saveOrUpdate(additionalStudio);

        User updatedUser = (User) genericUser.getById(5);
        Set<Studio> updatedStudios = updatedUser.getStudiosOfStudent();

        assertEquals(3, updatedStudios.size());
    }

    /**
     * Verifies that I can remove a student from a studio
     */
    @Test
    void testRemoveStudent() {
       GenericDao genericUser = new GenericDao(User.class);
       User user = (User) genericUser.getById(5);

       Studio quitStudio = (Studio)genericDao.getById(5);

       Set<User> studioStudents = quitStudio.getStudentsInStudio();

       studioStudents.remove(user);
       genericDao.saveOrUpdate(quitStudio);

       User updatedUser = (User) genericUser.getById(5);
       Set<Studio> updatedStudioSet = updatedUser.getStudiosOfStudent();

       assertEquals(1, updatedStudioSet.size());
    }
}