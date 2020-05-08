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
 * Allows a teacher to delete a practice hack they have written.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/deletePracticeHack"}
)
public class DeletePracticeHackAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao practiceHackDao = new GenericDao(PracticeHack.class);
        GenericDao userDao = new GenericDao(User.class);

        // Get the ID of the practice hack to delete
        int deleteId = Integer.parseInt(req.getParameter("practiceHackToDelete"));
        PracticeHack practiceHackToDelete = (PracticeHack)practiceHackDao.getById(deleteId);

        // Delete the practice hack
        practiceHackDao.delete(practiceHackToDelete);

        // Reset the updated user into the session for "author"
        User currentUser = (User)session.getAttribute("user");
        User updatedUser = (User)userDao.getById(currentUser.getId());

        session.setAttribute("user", updatedUser);

        resp.sendRedirect(req.getContextPath() + "/viewPracticeHacks.jsp");

    }
}