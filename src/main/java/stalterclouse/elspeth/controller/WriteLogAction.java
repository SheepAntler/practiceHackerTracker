package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.PracticeLog;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Adds a practice session to the user's log and updates the user's practiceCounter accordingly.
 *
 * @author Elspeth Stalter-Clouse
 */

@WebServlet(
        urlPatterns = {"/writeLog"}
)
@Log4j2
public class WriteLogAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Set processing variables
        HttpSession session = req.getSession();
        GenericDao userDao = new GenericDao(User.class);
        GenericDao logDao = new GenericDao(PracticeLog.class);
        User storedUser = (User)session.getAttribute("user");
        User currentUser = (User)userDao.getById(storedUser.getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Create a new log with the form inputs
        LocalDate practiceDate = LocalDate.now();
        String startTime = practiceDate.toString() + " " + req.getParameter("startTime");
        String endTime = practiceDate.toString() + " " + req.getParameter("endTime");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        String activities = req.getParameter("activities");
        String notes = req.getParameter("notes");

        log.debug( startDateTime + " " + endDateTime);

        PracticeLog newLog = new PracticeLog(currentUser, practiceDate, startDateTime, endDateTime, activities, notes, "");

        // Get the last date the user entered
        List<PracticeLog> currentUserLogs = new ArrayList<PracticeLog>(logDao.getByPropertyEqual("user", currentUser.getId()));
        log.debug(currentUserLogs);
        LocalDate lastPracticeDate = currentUserLogs.get(currentUserLogs.size() - 1).getPracticeDate();
        log.debug(lastPracticeDate);

        // find the difference between the two dates
        int timeSinceLastPractice = (int) ChronoUnit.HOURS.between(practiceDate, lastPracticeDate);
        log.debug(timeSinceLastPractice);

        //TODO If it's been more than 24 hours since the last log (user.practiceLogs.get(0)--you MIGHT have convert this to an ArrayList first)
        // reset the practice counter to 0

        //TODO If it hasn't been more than 24 hours, reset the practice counter to practice counter + 1

        //TODO save the log

        //TODO update the user

        resp.sendRedirect(req.getContextPath() + "/logWriter.jsp");
    }
}
