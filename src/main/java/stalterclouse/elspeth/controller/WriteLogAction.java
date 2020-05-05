package stalterclouse.elspeth.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Adds a practice session to the user's log and updates the user's practiceCounter accordingly.
 *
 * @author Elspeth Stalter-Clouse
 */

@WebServlet(
        urlPatterns = {"/writeLog"}
)
public class WriteLogAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO Create a new Log object...figure out what's going on with Times/Datetimes, ok?

        //TODO If it's been more than 24 hours since the last log (user.practiceLogs.get(0)--you MIGHT have convert this to an ArrayList first)
        // reset the practice counter to 0

        //TODO If it hasn't been more than 24 hours, reset the practice counter to practice counter + 1

        //TODO save the log

        resp.sendRedirect(req.getContextPath() + "/logWriter.jsp");
    }
}
