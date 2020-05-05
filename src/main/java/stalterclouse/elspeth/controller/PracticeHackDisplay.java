package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.PracticeHack;
import stalterclouse.elspeth.entity.Studio;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Retrieves the appropriate practice hacks for each user.
 *
 * @author Elspeth Stalter-Clouse
 */

@WebServlet(
        urlPatterns = {"/practiceHacks"}
)
@Log4j2
public class PracticeHackDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao practiceHackDao = new GenericDao(PracticeHack.class);
        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");

        Map<String, Object> propertyMap = new HashMap<String, Object>();
        propertyMap.put("instrument", currentUser.getInstrument().getInstrument());
        propertyMap.put("skillLevel", currentUser.getInstrument().getSkillLevel());
        List<PracticeHack> personalPracticeHacks = practiceHackDao.getByPropertiesEqual(propertyMap);

        if (currentUser.getRole().getRole().equals("practiceHacker")) {
            session.setAttribute("personalPracticeHacks", personalPracticeHacks);
        }
        else if (currentUser.getRole().getRole().equals("student")) {
            List<Studio> studioArrayList = new ArrayList<Studio>(currentUser.getStudiosOfStudent());
            if (!studioArrayList.isEmpty()) {
                Studio studio = studioArrayList.get(0);
                User teacher = studio.getTeacher();
                propertyMap.put("user", teacher);
                List<PracticeHack> practiceHacksFromTeacher = practiceHackDao.getByPropertiesEqual(propertyMap);
                session.setAttribute("practiceHacksFromTeacher", practiceHacksFromTeacher);
            } else if (studioArrayList.isEmpty() && session.getAttribute("studentStudio") != null) {
                Studio newStudio = (Studio)session.getAttribute("studentStudio");
                User teacher = newStudio.getTeacher();
                propertyMap.put("user", teacher);
                List<PracticeHack> practiceHacksFromTeacher = practiceHackDao.getByPropertiesEqual(propertyMap);
                session.setAttribute("practiceHacksFromTeacher", practiceHacksFromTeacher);
            } else {
                session.setAttribute("personalPracticeHacks", personalPracticeHacks);
            }
        } else if (currentUser.getRole().getRole().equals("teacher")) {
            String requestedHackView = req.getParameter("practiceHackView");

            if (requestedHackView.equals("allHacks")) {
                if (session.getAttribute("myPracticeHacks") != null) {
                    session.setAttribute("myPracticeHacks", null);
                } else if (session.getAttribute("personalPracticeHacks") != null) {
                    session.setAttribute("personalPracticeHacks", null);
                }
                List<PracticeHack> allPracticeHacks = practiceHackDao.getAllEntities();
                session.setAttribute("allPracticeHacks", allPracticeHacks);
            } else if (requestedHackView.equals("authorMode")) {
                if (session.getAttribute("allPracticeHacks") != null) {
                    session.setAttribute("allPracticeHacks", null);
                } else if (session.getAttribute("personalPracticeHacks") != null) {
                    session.setAttribute("personalPracticeHacks", null);
                }
                List<PracticeHack> myPracticeHacks = practiceHackDao.getByPropertyEqual("user", currentUser);
                session.setAttribute("myPracticeHacks", myPracticeHacks);
            } else if (requestedHackView.equals("practiceMode")) {
                if (session.getAttribute("allPracticeHacks") != null) {
                    session.setAttribute("allPracticeHacks", null);
                } else if (session.getAttribute("myPracticeHacks") != null) {
                    session.setAttribute("myPracticeHacks", null);
                }
                session.setAttribute("personalPracticeHacks", personalPracticeHacks);
            }

            session.setAttribute("practiceHackViewSelected", true);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewPracticeHacks.jsp");
        dispatcher.forward(req, resp);

    }
}
