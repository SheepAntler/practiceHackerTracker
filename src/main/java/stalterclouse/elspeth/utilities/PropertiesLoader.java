package stalterclouse.elspeth.utilities;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Eric Knapp
 */
public interface PropertiesLoader {

    /**
     * Loads a properties file for whichever programs are implementing the PropertiesLoader interface.
     *
     * @param  propertiesFilePath the name of the properties file
     * @return the loaded properties file
     * @throws IOException if the properties file cannot be loaded
     * @throws Exception if there is a more general error
     */
    default Properties loadProperties(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            System.out.println("Oh dear. It seems we couldn't read that file.");
            ioException.printStackTrace();
            throw ioException;
        } catch (Exception exception) {
            System.out.println("Blast! General pillishness has caused an error!");
            exception.printStackTrace();
            throw exception;
        }
        return properties;
    }
}
