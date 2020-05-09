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

@WebServlet(
        urlPatterns = {"/leaveStudio"}
)
@Log4j2
public class LeaveStudioAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");
        Studio currentStudio = (Studio)session.getAttribute("studentStudio");
        GenericDao studioDao = new GenericDao(Studio.class);
        GenericDao studentDao = new GenericDao(User.class);

        Studio studioToQuit = (Studio)studioDao.getById(currentStudio.getId());
        Set<User> currentStudioStudents = studioToQuit.getStudentsInStudio();
        User departingStudent = (User)studentDao.getById(currentUser.getId());

        currentStudioStudents.remove(departingStudent);

        studioDao.saveOrUpdate(studioToQuit);

        session.removeAttribute("studentStudio");
        session.setAttribute("practiceHacksFromTeacher", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("studioInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
