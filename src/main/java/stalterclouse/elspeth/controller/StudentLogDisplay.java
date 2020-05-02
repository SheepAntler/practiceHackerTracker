package stalterclouse.elspeth.controller;

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
import java.util.List;

/**
 * Displays a specific student's practice log for a teacher
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/viewStudentLogs"}
)
public class StudentLogDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao userDao = new GenericDao(User.class);
        HttpSession session = req.getSession();
        String requestedStudent = req.getParameter("studentsInStudio");

        List<User> student = userDao.getByPropertyEqual("username", requestedStudent);

        //TODO use this to dynamically output student logs when a search has happened...find a way to clear the log afterwards, though
        session.setAttribute("studentLog", student.get(0));
        session.setAttribute("logAcquired", true);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewStudentLogs.jsp");
        dispatcher.forward(req, resp);

    }
}
