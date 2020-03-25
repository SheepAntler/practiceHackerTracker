package stalterclouse.elspeth.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.ImslpResponse;
import stalterclouse.elspeth.entity.OpenOpusResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Log4j2
public class OpenOpusDao {

    /**
     * Returns the OpenOpusResponse object
     */
    OpenOpusResponse getComposerList() {
        Client client = ClientBuilder.newClient();
        // TODO read in URI from a properties file!
        WebTarget target =
                client.target("https://api.openopus.org/composer/list/search/mendelssohn.json");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        OpenOpusResponse openOpusResponse = null;

        try {
            openOpusResponse = mapper.readValue(response, OpenOpusResponse.class);
        } catch (JsonProcessingException e) {
            log.error("Problem processing JSON ", e);
        }
        return openOpusResponse;
    }
}
