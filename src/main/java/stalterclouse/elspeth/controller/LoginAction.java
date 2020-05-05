package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.Studio;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Logs in the user and gets their dashboard display data.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/dashboard"}
)
@Log4j2
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao userDao = new GenericDao(User.class);
        HttpSession session = req.getSession();
        String currentUser = req.getRemoteUser();

//        List<User> user = userDao.getByPropertyEqual("username", currentUser);
        User user = (User)userDao.getByPropertyEqual("username", currentUser).get(0);

        session.setAttribute("user", user);
        session.setAttribute("userId", user.getId());

        if (user.getRole().getRole().equals("teacher")) {
//            log.debug(user.get(0).getStudios());
            List<Studio> studios = new ArrayList<Studio>(user.getStudios());
//            session.setAttribute("studios", studios);
//            log.debug("About to make the map");
            Map<String, ArrayList<User>> studioStudents = new HashMap<String, ArrayList<User>>();
            for (Studio studio : studios) {
                String studioName = studio.getInstrument() + " Studio at " + studio.getOrganizationName();
//                log.debug(studioName);
                ArrayList<User> students = new ArrayList<User>(studio.getStudentsInStudio());
                studioStudents.put(studioName, students);
            }

            session.setAttribute("studios", studioStudents);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }
}
