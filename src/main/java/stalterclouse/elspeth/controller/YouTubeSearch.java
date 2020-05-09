package stalterclouse.elspeth.controller;

import stalterclouse.elspeth.entity.youtube.Id;
import stalterclouse.elspeth.entity.youtube.ItemsItem;
import stalterclouse.elspeth.persistence.YouTubeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Processes a user search term and sends it to YouTube.
 *
 * @author Elspeth Stalter-Clouse
 */
@WebServlet(
        urlPatterns = {"/youTubeSearch"}
)
public class YouTubeSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        YouTubeDao youTubeDao = new YouTubeDao();
        String userSearchTerm = req.getParameter("userSearch").replaceAll("\\s","%20");

        // Call the YouTube API with the user's search term
        List<ItemsItem> results = youTubeDao.getYouTubeResponse(userSearchTerm).getItems();

        req.setAttribute("searchResults", results);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/youTubeSearch.jsp");
        dispatcher.forward(req, resp);

    }
}
