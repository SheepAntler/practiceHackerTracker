package stalterclouse.elspeth.utilities;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Provides access to the database
 * Created on 8/31/16.
 *
 * @author pwaite
 * @author Alex M - Fall 2019 - added multi-line sql capability
 */
@Log4j2
public class Database implements PropertiesLoader {

    // create an object of the class Database
    private static Database instance = new Database();

    private Properties properties;
    private Connection connection;

    // private constructor prevents instantiating this class anywhere else
    private Database() {
        //loadProperties();
        try {
            properties = loadProperties("/database.properties");
        } catch (Exception e) {
            log.error("You've got Property Problems! ", e);
        }

    }

    // TODONE! use properties loader (interface from adv java)
//    private void loadProperties() {
//        properties = new Properties();
//        try {
//            properties.load (this.getClass().getResourceAsStream("/database.properties"));
//        } catch (IOException ioe) {
//            System.out.println("Database.loadProperties()...Cannot load the properties file");
//            ioe.printStackTrace();
//        } catch (Exception e) {
//            System.out.println("Database.loadProperties()..." + e);
//            e.printStackTrace();
//        }
//
//    }

    // get the only Database object available
    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"),  properties.getProperty("password"));
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Cannot close database connection" + e);
            }
        }

        connection = null;
    }

    /**
     * Run the sql.
     *
     * @param sqlFile the sql file to be read and executed line by line
     */
    public void runSQL(String sqlFile) {

        Statement stmt = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(sqlFile))))  {

            connect();
            stmt = connection.createStatement();

            String sql = "";
            while (br.ready())
            {
                char inputValue = (char)br.read();

                if(inputValue == ';')
                {
                    stmt.executeUpdate(sql);
                    sql = "";
                }
                else
                    sql += inputValue;
            }

        } catch (SQLException se) {
            log.error("We've got a SQL exception, folks!", se);
        } catch (Exception e) {
            log.error("You've got some general SQL problems", e);
        } finally {
            disconnect();
        }

    }
}