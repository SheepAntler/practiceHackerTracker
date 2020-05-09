package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.Instrument;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Updates the user's profile.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/editProfile"}
)
@Log4j2
public class EditProfileAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");
        GenericDao userDao = new GenericDao(User.class);
        GenericDao instrumentDao = new GenericDao(Instrument.class);
        Instrument userInstrument = (Instrument)instrumentDao.getById(currentUser.getInstrument().getId());

        // Get any changes from the form fields
        String skillLevel = req.getParameter("skillLevel");
        String email = req.getParameter("email");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        int zipCode = Integer.parseInt(req.getParameter("zip"));

        userInstrument.setSkillLevel(skillLevel);
        currentUser.setEmail(email);
        currentUser.setCity(city);
        currentUser.setState(state);
        currentUser.setZipCode(zipCode);

        instrumentDao.saveOrUpdate(userInstrument);
        userDao.saveOrUpdate(currentUser);
        User updatedUser = (User)userDao.getById(currentUser.getId());

        session.setAttribute("user", updatedUser);

        resp.sendRedirect(req.getContextPath() + "/profile.jsp");

    }
}
