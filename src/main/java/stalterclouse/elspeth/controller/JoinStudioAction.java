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
import java.util.Set;

/**
 * Adds a student to a selected studio.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/joinStudio"}
)
@Log4j2
public class JoinStudioAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");
        GenericDao studentDao = new GenericDao(User.class);
        GenericDao studioDao = new GenericDao(Studio.class);
        int selectedStudio = Integer.parseInt(req.getParameter("studioOption"));

        Studio studioToJoin = (Studio)studioDao.getById(selectedStudio);
        Set<User> currentStudioStudents = studioToJoin.getStudentsInStudio();
        User joiningStudent = (User)studentDao.getById(currentUser.getId());

        currentStudioStudents.add(joiningStudent);

        studioDao.saveOrUpdate(studioToJoin);

        session.setAttribute("studentStudio", studioToJoin);

        RequestDispatcher dispatcher = req.getRequestDispatcher("studioInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
