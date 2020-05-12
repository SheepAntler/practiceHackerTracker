package stalterclouse.elspeth.controller;

import stalterclouse.elspeth.entity.Instrument;
import stalterclouse.elspeth.entity.Studio;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Dynamically generates a list of instruments from teacher's studio set
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/practiceHackWriter"}
)
public class BuildPracticeHackWriter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao studioDao = new GenericDao(Studio.class);
        User currentUser = (User)session.getAttribute("user");

        List<Studio> studioList = new ArrayList<Studio>(studioDao.getByPropertyEqual("teacher", currentUser.getId()));

        Set<String> studioInstrumentSet = new HashSet<String>();

        for (Studio studio : studioList) {
            studioInstrumentSet.add(studio.getInstrument());
        }

        session.setAttribute("teacherInstruments", studioInstrumentSet);

        resp.sendRedirect(req.getContextPath() + "/practiceHackWriter.jsp");

    }
}
