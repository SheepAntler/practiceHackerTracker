package stalterclouse.elspeth.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Logs in the user and gets their dashboard display data.
 *
 * @author Elspeth Stalter-Clouse
 */

@WebServlet(
        urlPatterns = {"/logout"}
)
public class LogoutAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/index.jsp");

    }
}
