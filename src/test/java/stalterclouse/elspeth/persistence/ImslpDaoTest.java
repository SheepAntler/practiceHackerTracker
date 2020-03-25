package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.imslp.JsonMember0;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImslpDaoTest {

    ImslpDao dao;

    @BeforeEach
    void setUp() {
        dao = new ImslpDao();
    }

    @Test
    void getComposerCategoryLinkSuccess() {
        JsonMember0 expectedComposerCategoryLink = new JsonMember0("Category:Bach, Johann Sebastian", "https://imslp.org/wiki/Category:Bach,_Johann_Sebastian");
        JsonMember0 returnedComposerCategoryLink = new JsonMember0(dao.getJsonData().getJsonMember0().getId(), dao.getJsonData().getJsonMember0().getPermlink());

        assertEquals(expectedComposerCategoryLink, returnedComposerCategoryLink);
    }
}
