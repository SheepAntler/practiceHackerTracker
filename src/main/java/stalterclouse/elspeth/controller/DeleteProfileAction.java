package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Deletes a user account.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/deleteAccount"}
)
@Log4j2
public class DeleteProfileAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");
        GenericDao userDao = new GenericDao(User.class);

        session.removeAttribute("user");
        userDao.delete(currentUser);

        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/goodbye.jsp");

//        RequestDispatcher dispatcher = req.getRequestDispatcher("/goodbye.jsp");
//        dispatcher.forward(req, resp);

    }
}
