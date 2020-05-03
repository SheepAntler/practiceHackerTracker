package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.PracticeHack;
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

        if (currentUser.getRole().getRole().equals("student") || currentUser.getRole().getRole().equals("practiceHacker")) {
            Map<String, String> propertyMap = new HashMap<String, String>();
            propertyMap.put("instrument", currentUser.getInstrument().getInstrument());
            propertyMap.put("skillLevel", currentUser.getInstrument().getSkillLevel());
            List<PracticeHack> practiceHacks = practiceHackDao.getByPropertiesEqual(propertyMap);
            session.setAttribute("practiceHacks", practiceHacks);
            log.debug(practiceHacks);
        } else if (currentUser.getRole().equals("teacher")) {
            //TODO process the form inputs
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewPracticeHacks.jsp");
        dispatcher.forward(req, resp);

    }
}
