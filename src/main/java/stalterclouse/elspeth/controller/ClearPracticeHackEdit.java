package stalterclouse.elspeth.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Resets Practice Hack Writer from Edit mode to Write mode
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/exitEditMode"}
)
public class ClearPracticeHackEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("practiceHackToEdit", null);

        resp.sendRedirect(req.getContextPath() + "/viewPracticeHacks.jsp");

    }

}
