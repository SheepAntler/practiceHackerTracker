package stalterclouse.elspeth.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.youtube.YouTubeResponse;
import stalterclouse.elspeth.utilities.PropertiesLoader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

@Log4j2
public class YouTubeDao implements PropertiesLoader {

    private Properties youTubeProperties;

    public YouTubeDao() {
        try {
            youTubeProperties = loadProperties("/api.properties");
        } catch (Exception exception) {
            log.error("I'm sorry! I didn't load the properties! ", exception);
        }
    }

    /**
     * Returns results from a YouTube search.
     */
    public YouTubeResponse getYouTubeResponse(String userQuery) {

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(youTubeProperties.getProperty("youTube.baseUrl") + "?part=snippet&maxResults=4&q="
                        + userQuery + "&key=" + youTubeProperties.getProperty("youTube.key"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        YouTubeResponse youTubeResponse = null;

        try {
            youTubeResponse = mapper.readValue(response, YouTubeResponse.class);
        } catch (JsonProcessingException exception) {
            log.error("Rats! I couldn't process that JSON object. ", exception);
        }

        return youTubeResponse;
    }
}
