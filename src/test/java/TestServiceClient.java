import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testComposerJSON() throws Exception {
//        Client opusClient = ClientBuilder.newClient();
//        WebTarget opusTarget =
//                opusClient.target("https://api.openopus.org/composer/list/search/mendelssohn.json");
//        String opusResponse = opusTarget.request(MediaType.APPLICATION_JSON).get(String.class);
//        String expectedResponse = "{\"status\":{\"version\":\"1.19.11\",\"success\":\"true\",\"source\":\"db\",\"rows\":1,\"processingtime\":0.0016880035400390625,\"api\":\"Open Opus-cache\"},\"request\":{\"type\":\"search\",\"item\":\"mendelssohn\"},\"composers\":[{\"id\":\"147\",\"name\":\"Mendelssohn\",\"complete_name\":\"Felix Mendelssohn\",\"birth\":\"1809-01-01\",\"death\":\"1847-01-01\",\"epoch\":\"Romantic\",\"portrait\":\"https:\\/\\/assets.openopus.org\\/portraits\\/77325243-1568084923.jpg\"}]}";
//        assertEquals(expectedResponse, opusResponse);

//        ObjectMapper mapper = new ObjectMapper();
//        Composer composer = mapper.readValue(opusResponse, Composer.class);
//        List<ComposersItem> composers = composer.getComposers();
//        String fullName = "";
//        for (ComposersItem listedComposer : composers) {
//            fullName = listedComposer.getCompleteName();
//        }
//        assertEquals("Felix Mendelssohn", fullName);
    }

/*
    IMSLP's JSON data is returned in kind of a crazy way.
    I'm going to have to come back to this later to figure out a better way to use it.

    Also, this stupid test is NEVER going to pass because of that awful timestamp. YUCK.
    Commenting out for now, but we'll see what I can do about it later...
 */
//    @Test
//    public void testImslpJSON() throws Exception {
//        Client imslpClient = ClientBuilder.newClient();
//        WebTarget imslpTarget =
//                imslpClient.target("https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=1382/limit=1/retformat=json");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        String imslpResponse = imslpTarget.request(MediaType.APPLICATION_JSON).get(String.class);
        //String expectedResponse = "{\"0\":{\"id\":\"Category:Bach, Johann Sebastian\",\"type\":\"1\",\"parent\":\"\",\"intvals\":[],\"permlink\":\"https:\\/\\/imslp.org\\/wiki\\/Category:Bach,_Johann_Sebastian\"},\"metadata\":{\"start\":1382,\"limit\":1,\"sortby\":\"id\",\"sortdirection\":\"ASC\",\"moreresultsavailable\":true,\"timestamp\":" + timestamp.getTime() + ",\"apiversion\":10}}";
        //assertEquals(expectedResponse, imslpResponse);
//    }
}
