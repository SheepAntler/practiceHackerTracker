package stalterclouse.elspeth.controller;

import stalterclouse.elspeth.entity.PracticeHack;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/getPracticeHack"}
)
public class RetrievePracticeHack extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao practiceHackDao = new GenericDao(PracticeHack.class);

        int practiceHackId = Integer.parseInt(req.getParameter("practiceHackToEdit"));

        PracticeHack practiceHackToEdit = (PracticeHack)practiceHackDao.getById(practiceHackId);

        session.setAttribute("practiceHackToEdit", practiceHackToEdit);

        resp.sendRedirect(req.getContextPath() + "/practiceHackWriter.jsp");

    }
}
