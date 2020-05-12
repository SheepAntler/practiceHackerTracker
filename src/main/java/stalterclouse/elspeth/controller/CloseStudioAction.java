package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.Studio;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Allows a teacher to close a studio.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/closeStudio"}
)
@Log4j2
public class CloseStudioAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug(req.getParameter("studioToClose"));

        HttpSession session = req.getSession();
        GenericDao userDao = new GenericDao(User.class);
        GenericDao studioDao = new GenericDao(Studio.class);

        // Get the form entry
        int closingStudioId = Integer.parseInt(req.getParameter("studioToClose"));

        // Get the studio and delete it
        studioDao.delete(studioDao.getById(closingStudioId));

        // Reset the User into the session
        User userToUpdate = (User)session.getAttribute("user");
        User updatedUser = (User)userDao.getById(userToUpdate.getId());
        session.removeAttribute("user");
        session.setAttribute("user", updatedUser);

        req.setAttribute("successMessage", "Your studio was successfully closed. You can create another one anytime!");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/teacherAdmin.jsp");
        dispatcher.forward(req, resp);

    }
}
