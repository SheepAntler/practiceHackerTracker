package stalterclouse.elspeth.controller;

import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Logs in the user and gets their dashboard display data.
 *
 * @author Elspeth Stalter-Clouse
 */

@WebServlet(
        urlPatterns = {"/login"}
)
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao userDao = new GenericDao(User.class);

        //TODO get data to display for students and practiceHackers


        //TODO get data to display for teachers

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }
}
