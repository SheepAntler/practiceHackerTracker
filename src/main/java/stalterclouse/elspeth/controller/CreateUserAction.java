package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.Instrument;
import stalterclouse.elspeth.entity.Role;
import stalterclouse.elspeth.entity.Studio;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Creates a new user.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/createAccount"}
)
@Log4j2
public class CreateUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Instantiate the dao types you might need
        GenericDao userDao = new GenericDao(User.class);
        GenericDao studioDao = new GenericDao(Studio.class);
        GenericDao roleDao = new GenericDao(Role.class);
        GenericDao instrumentDao = new GenericDao(Instrument.class);

        // Prepare variables for creation
        User newUser = null;
        Instrument newUserInstrument = null;
        Studio newStudio = null;
        Role newUserRole = null;

        // Get entries for all user types
        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String role = req.getParameter("accountType");

        // Get the appropriate additional form entries for each user type
        if (role.equals("teacher")) {
            String studioInstrument = req.getParameter("studioInstrument");
            String studioOrganization = req.getParameter("studioName");
            String studioAddress = req.getParameter("studioAddress");
            String studioCity = req.getParameter("studioCity");
            String studioState = req.getParameter("studioState");
            int studioZip = Integer.parseInt(req.getParameter("studioZip"));

            newUser = new User(username, password, firstName, lastName, email, 0, null, null, null, 0, 0);
            newUserInstrument = new Instrument(newUser, studioInstrument, "Professional");
            newStudio = new Studio(newUser, studioInstrument, studioOrganization, studioAddress, studioCity, studioState, studioZip);
            newUserRole = new Role(newUser, username, role);
        } else if (role.equals("student")) {
            String studentInstrument = req.getParameter("studentInstrument");
            String studentSkillLevel = req.getParameter("studentSkillLevel");
            LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
            String studentCity = req.getParameter("studentCity");
            String studentState = req.getParameter("studentState");
            int studentZip = Integer.parseInt(req.getParameter("studentZip"));

            newUser = new User(username, password, firstName, lastName, email, 0, birthDate, studentCity, studentState, studentZip, 0);
            newUserInstrument = new Instrument(newUser, studentInstrument, studentSkillLevel);
            newUserRole = new Role(newUser, username, role);
        } else if (role.equals("practiceHacker")) {
            String userInstrument = req.getParameter("instrument");
            String userSkillLevel = req.getParameter("skillLevel");
            String userCity = req.getParameter("city");
            String userState = req.getParameter("state");
            int userZip = Integer.parseInt(req.getParameter("zip"));

            newUser = new User(username, password, firstName, lastName, email, 0, null, userCity, userState, userZip, 0);
            newUserInstrument = new Instrument(newUser, userInstrument, userSkillLevel);
            newUserRole = new Role(newUser, username, role);
        }

        // Check to see if the username already exists
        List<User> usernamesFromDatabase = userDao.getByPropertyEqual("username", username);

        if (usernamesFromDatabase.size() == 0) {
            userDao.insert(newUser);
            roleDao.insert(newUserRole);
            instrumentDao.insert(newUserInstrument);
            if (role.equals("teacher")) {
                studioDao.insert(newStudio);
            }

            String welcomeMessage = "This will be a message to welcome a first-time user. It will have helpful links.";

            req.login(username, password);

            req.setAttribute("welcomeMessage", welcomeMessage);

            resp.sendRedirect("dashboard");

        } else {
            String errorMessage = "We're so sorry; that username was already taken! Please try again (and make sure you double check your account type!)";

            req.setAttribute("newUser", newUser);
            req.setAttribute("newInstrument", newUserInstrument);
            if (role.equals("teacher")) {
                req.setAttribute("newStudio", newStudio);
            }

            req.setAttribute("errorMessage", errorMessage);

            RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
