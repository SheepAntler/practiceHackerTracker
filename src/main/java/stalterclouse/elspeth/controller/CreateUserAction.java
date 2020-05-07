package stalterclouse.elspeth.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Creates a new user.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/createAccount"}
)
public class CreateUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO get form field entries (based on user type)
        //TODO get all usernames from DB
        //TODO if username isn't taken, create new AUTO LOG-IN the user and display welcome message on index page ("Welcome! here's a link to adding a studio. here's a link to your profile. here's a link to logging")
        //TODO if username is taken, set variables in the request along with an error message, and display all values except for the username
    }
}
