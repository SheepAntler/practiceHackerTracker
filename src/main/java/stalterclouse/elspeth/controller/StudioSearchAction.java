package stalterclouse.elspeth.controller;

import stalterclouse.elspeth.entity.Studio;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

/**
 * Allows the User to search for a studio to join.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/studioSearch"}
)
public class StudioSearchAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao studioDao = new GenericDao(Studio.class);
        User currentUser = (User)session.getAttribute("user");
        Map<String, String> propertyMap = new HashMap<String, String>();
        List<Studio> availableStudios = null;
        String searchParameter = req.getParameter("searchParameter");
        String userInstrument = currentUser.getInstrument().getInstrument();
        String userState = currentUser.getState();
        String userCity = currentUser.getCity();
        String studioViewMessage = "";

        if (searchParameter.equals("allStudios")) {
            availableStudios = new ArrayList<Studio>(studioDao.getByPropertyEqual("instrument", userInstrument));
            studioViewMessage = "Viewing Studios all over the Country";
        } else if (searchParameter.equals("state")) {
            propertyMap.put("instrument", userInstrument);
            propertyMap.put("state", userState);
            availableStudios = new ArrayList<Studio>(studioDao.getByPropertiesEqual(propertyMap));
            studioViewMessage = "Viewing Studios in " + userState;
        } else if (searchParameter.equals("city")) {
            propertyMap.put("instrument", userInstrument);
            propertyMap.put("state", userState);
            propertyMap.put("city", userCity);
            availableStudios = new ArrayList<Studio>(studioDao.getByPropertiesEqual(propertyMap));
            studioViewMessage = "Viewing Studios in " + userCity + ", " + userState;
        }

        session.setAttribute("availableStudios", availableStudios);
        session.setAttribute("studiosFound", true);
        req.setAttribute("studioViewMessage", studioViewMessage);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/studioInfo.jsp");
        dispatcher.forward(req, resp);
    }
}
