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
        LocalDateTime hailMaryInsertDate = LocalDateTime.now();
        log.debug("generated date: {}", practiceDate);
        String startTime = practiceDate.toString() + " " + req.getParameter("startTime");
        String endTime = practiceDate.toString() + " " + req.getParameter("endTime");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        String activities = req.getParameter("activities");
        String notes = req.getParameter("notes");

        PracticeLog newLog = new PracticeLog(currentUser, hailMaryInsertDate, startDateTime, endDateTime, activities, notes, null);

        // Get the last date the user entered
        List<PracticeLog> currentUserLogs = new ArrayList<PracticeLog>(logDao.getByPropertyEqual("user", currentUser.getId()));

        if (currentUserLogs.size() == 0) {
            currentUser.setPracticeCounter(1);
            currentUser.setLongestStreak(1);
        } else {
            LocalDateTime lastPracticeDate = currentUserLogs.get(currentUserLogs.size() - 1).getPracticeDate();

            // If the user isn't logging two sessions in the same day...
            if (hailMaryInsertDate != lastPracticeDate) {
                // calculate the difference between the two dates
                int daysSinceLastPractice = (int) ChronoUnit.DAYS.between(lastPracticeDate, hailMaryInsertDate);
                // if the timeSinceLastPractice date is greater than 1 day, reset practice counter and update user
                if (daysSinceLastPractice > 1) {
                    currentUser.setPracticeCounter(0);
                    log.debug(currentUser.getPracticeCounter());
                } else {
                    // otherwise, increment practice counter
                    int currentCounter = currentUser.getPracticeCounter();
                    int incrementedCounter = currentCounter + 1;
                    log.debug(incrementedCounter);
                    // if that counter is greater than the longest streak, update the longest streak!
                    if (incrementedCounter > currentUser.getLongestStreak()) {
                        currentUser.setLongestStreak(incrementedCounter);
                    }

                    currentUser.setPracticeCounter(incrementedCounter);
                }
                // update the user with all these changes
                //userDao.saveOrUpdate(currentUser);
            }
        }
        // save the log
        logDao.insert(newLog);

        userDao.saveOrUpdate(currentUser);

        resp.sendRedirect(req.getContextPath() + "/logWriter.jsp");
    }
}
