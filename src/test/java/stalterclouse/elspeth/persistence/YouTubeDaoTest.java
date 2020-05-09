package stalterclouse.elspeth.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stalterclouse.elspeth.entity.youtube.YouTubeResponse;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YouTubeDaoTest {

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

        String userQuery = ("long long ago").replaceAll("\\s","%20");

        int expectedResultsNumber = 4;
        int actualResultsNumber = dao.getYouTubeResponse(userQuery).getItems().size();

        assertEquals(expectedResultsNumber, actualResultsNumber);
    }
}
