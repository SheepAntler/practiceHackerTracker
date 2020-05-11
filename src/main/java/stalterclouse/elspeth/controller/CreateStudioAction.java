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
 * Allows a teacher to create a new studio.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/createStudio"}
)
@Log4j2
public class CreateStudioAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao userDao = new GenericDao(User.class);
        GenericDao studioDao = new GenericDao(Studio.class);
        User storedUser = (User)session.getAttribute("user");
        User currentUser = (User)userDao.getById(storedUser.getId());

        // Get the form entries
        String studioInstrument = req.getParameter("studioInstrument");
        String studioName = req.getParameter("studioName");
        String studioAddress = req.getParameter("studioAddress");
        String studioCity = req.getParameter("studioCity");
        String studioState = req.getParameter("studioState");
        Integer studioZip = Integer.parseInt(req.getParameter("studioZip"));

        // Create the new studio and insert it
        Studio newStudio = new Studio(currentUser, studioInstrument, studioName, studioAddress, studioCity, studioState, studioZip);
        studioDao.insert(newStudio);

        User updatedUser = (User)userDao.getById(storedUser.getId());
        session.removeAttribute("user");
        session.setAttribute("user", updatedUser);

        req.setAttribute("successMessage", "Your studio was successfully created, and students will now be able to join it.");

//        resp.sendRedirect(req.getContextPath() + "/teacherAdmin.jsp");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/teacherAdmin.jsp");
        dispatcher.forward(req, resp);


    }
}
