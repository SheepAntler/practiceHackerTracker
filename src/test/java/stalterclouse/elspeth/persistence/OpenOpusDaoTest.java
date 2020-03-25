package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.openopus.ComposersItem;

import static org.junit.jupiter.api.Assertions.*;

public class OpenOpusDaoTest {

    OpenOpusDao dao;

    @BeforeEach
    void setUp() {
        dao = new OpenOpusDao();
    }

    @Test
    void getComposerSuccess() {
        ComposersItem expectedComposer = new ComposersItem("Felix Mendelssohn", "1847-01-01", "Mendelssohn", "1809-01-01", "Romantic", "147");
        ComposersItem returnedComposer = null;

        for (ComposersItem composer : dao.getComposerList().getComposers()) {
            returnedComposer = new ComposersItem(composer.getCompleteName(), composer.getDeath(), composer.getName(), composer.getBirth(), composer.getEpoch(), composer.getId());
        }

        assertEquals(expectedComposer, returnedComposer);
    }

}
