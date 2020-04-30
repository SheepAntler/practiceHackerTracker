package stalterclouse.elspeth.controller;

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
import java.util.List;

/**
 * Logs in the user and gets their dashboard display data.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/dashboard"}
)
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao userDao = new GenericDao(User.class);
        HttpSession session = req.getSession();
        String currentUser = req.getRemoteUser();

        //TODO get data to display for students and practiceHackers
        List<User> user = userDao.getByPropertyEqual("username", currentUser);

        session.setAttribute("user", user.get(0));

        //TODO get data to display for teachers
        if (user.get(0).getRole().getRole().equals("teacher")) {
            List<Studio> studios = new ArrayList<Studio>(user.get(0).getStudios());
            session.setAttribute("studios", studios);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }
}
