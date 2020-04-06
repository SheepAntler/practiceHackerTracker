package stalterclouse.elspeth.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.imslp.ImslpResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Log4j2
public class ImslpDao {

    /**
     * Returns the ImslpResponse object
     */
    ImslpResponse getJsonData() {
        Client client = ClientBuilder.newClient();
        // TODO read in URI from a properties file!
        WebTarget target =
                client.target("https://imslp.org/imslpscripts/API.ISCR.php?account=worklist/disclaimer=accepted/sort=id/type=1/start=1387/limit=1/retformat=json");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        ImslpResponse imslpResponse = null;

        try {
            imslpResponse = mapper.readValue(response, ImslpResponse.class);
        } catch (JsonProcessingException e) {
            log.error("Problem processing JSON ", e);
        }
        return imslpResponse;
    }
}
