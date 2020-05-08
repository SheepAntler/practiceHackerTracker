package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.PracticeHack;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Allows teachers to save changes to practice hacks they've written.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/editPracticeHack"}
)
@Log4j2
public class EditPracticeHack extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        PracticeHack practiceHackToEdit = (PracticeHack)session.getAttribute("practiceHackToEdit");
        GenericDao practiceHackDao = new GenericDao(PracticeHack.class);

        // Get whatever updates the user might have made
        String skillLevel = req.getParameter("skillLevel");
        String instrument = req.getParameter("instrument");
        String practiceHack = req.getParameter("practiceHack");

        // Update the practice hack
        practiceHackToEdit.setSkillLevel(skillLevel);
        practiceHackToEdit.setInstrument(instrument);
        practiceHackToEdit.setPracticeHack(practiceHack);

        // Save the updates in the database
        practiceHackDao.saveOrUpdate(practiceHackToEdit);

        // Clear the editable practice hack from the session
        session.removeAttribute("practiceHackToEdit");

        resp.sendRedirect(req.getContextPath() + "/viewPracticeHacks.jsp");
    }
}
