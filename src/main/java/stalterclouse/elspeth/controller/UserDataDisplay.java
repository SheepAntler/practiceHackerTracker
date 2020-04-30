package stalterclouse.elspeth.controller;

import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * If the user performs a search, they are taken to a results page.
 *
 * @author Elspeth Stalter-Clouse
 */

@WebServlet(
        urlPatterns = {"/viewProfile"}
)

public class UserDataDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao dao = new GenericDao(User.class);

        req.setAttribute("users", dao.getAllEntities());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(req, resp);

    }
}