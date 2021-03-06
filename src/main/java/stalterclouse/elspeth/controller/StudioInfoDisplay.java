package stalterclouse.elspeth.controller;

import stalterclouse.elspeth.entity.Studio;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

/**
 * Displays student studio information.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/studioInfo"}
)
public class StudioInfoDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao studioDao = new GenericDao(Studio.class);
        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");

        List<Studio> studentStudio = new ArrayList<Studio>(currentUser.getStudiosOfStudent());

        if (!studentStudio.isEmpty()) {
            session.setAttribute("studentStudio", studentStudio.get(0));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/studioInfo.jsp");
        dispatcher.forward(req, resp);

    }
}
