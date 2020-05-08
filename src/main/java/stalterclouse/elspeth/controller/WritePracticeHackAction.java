package stalterclouse.elspeth.controller;

import stalterclouse.elspeth.entity.PracticeHack;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Allows a teacher to write a practice hack to add to the archives.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/writePracticeHack"}
)
public class WritePracticeHackAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");
        GenericDao practiceHackDao = new GenericDao(PracticeHack.class);
        GenericDao userDao = new GenericDao(User.class);

        // Get the practice hack data from the form
        String skillLevel = req.getParameter("skillLevel");
        String instrument = req.getParameter("instrument");
        String practiceHack = req.getParameter("practiceHack");

        // Create the new practice hack and save it
        PracticeHack newPracticeHack = new PracticeHack(currentUser, skillLevel, instrument, practiceHack);
        practiceHackDao.insert(newPracticeHack);

        // Reset the updated user into the session for "author"
        User updatedUser = (User)userDao.getById(currentUser.getId());

        session.setAttribute("user", updatedUser);

        resp.sendRedirect(req.getContextPath() + "/viewPracticeHacks.jsp");

    }
}
