package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.imslp.JsonMember0;
import stalterclouse.elspeth.entity.youtube.YouTubeResponse;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YouTubeTest {

    YouTubeDao dao;

    @BeforeEach
    void setUp() {
        dao = new YouTubeDao();
    }

    @Test
    void getSearchResultsSuccess() {

        YouTubeResponse responseObject = dao.getYouTubeResponse("mozart");

        assertNotNull(responseObject);
    }

    @Test
    void getResultsNumberSuccess() {

        int expectedResultsNumber = 5;
        int actualResultsNumber = dao.getYouTubeResponse("long%20long%20ago").getItems().size();

        assertEquals(expectedResultsNumber, actualResultsNumber);
    }
}
