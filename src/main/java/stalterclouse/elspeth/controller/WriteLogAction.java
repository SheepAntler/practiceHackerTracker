package stalterclouse.elspeth.controller;

import lombok.extern.log4j.Log4j2;
import stalterclouse.elspeth.entity.PracticeLog;
import stalterclouse.elspeth.entity.User;
import stalterclouse.elspeth.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
        LocalDate simplePracticeDate = LocalDate.now();
        LocalDateTime practiceDate = LocalDateTime.now();
        String startTime = simplePracticeDate.toString() + " " + req.getParameter("startTime");
        String endTime = simplePracticeDate.toString() + " " + req.getParameter("endTime");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        String activities = req.getParameter("activities");
        String notes = req.getParameter("notes");

        PracticeLog newLog = new PracticeLog(currentUser, practiceDate, startDateTime, endDateTime, activities, notes, null);

        // Get the last date the user entered
        List<PracticeLog> currentUserLogs = new ArrayList<PracticeLog>(logDao.getByPropertyEqual("user", currentUser.getId()));

        if (currentUserLogs.size() == 0) {
            log.debug("starting user log for the first time");
            currentUser.setPracticeCounter(1);
            currentUser.setLongestStreak(1);
        } else {
            LocalDateTime lastPracticeDate = currentUserLogs.get(currentUserLogs.size() - 1).getPracticeDate();
            log.debug("finding last practice date: {}", lastPracticeDate);
            // If the user isn't logging two sessions in the same day...
            if (practiceDate != lastPracticeDate) {
                log.debug("last practice date is NOT the same as current practice date!");
                // calculate the difference between the two dates
                int daysSinceLastPractice = (int) ChronoUnit.DAYS.between(lastPracticeDate, practiceDate);
                log.debug("calculating days since last practice: {}", daysSinceLastPractice);
                // if the timeSinceLastPractice date is greater than 1 day, reset practice counter and update user
                if (daysSinceLastPractice > 1) {
                    log.debug("it's been more than 1 day...");
                    currentUser.setPracticeCounter(0);
                    log.debug("resetting currentUser counter to: {}", currentUser.getPracticeCounter());
                } else {
                    // otherwise, increment practice counter
                    log.debug("last practice was yesterday--awesome!");
                    int currentCounter = currentUser.getPracticeCounter();
                    int incrementedCounter = currentCounter + 1;
                    log.debug("user counter was incremented to: {}", incrementedCounter);
                    // if that counter is greater than the longest streak, update the longest streak!
                    if (incrementedCounter > currentUser.getLongestStreak()) {
                        currentUser.setLongestStreak(incrementedCounter);
                    }

                    currentUser.setPracticeCounter(incrementedCounter);
                }
            }
        }
        // save the log
        logDao.insert(newLog);
        // update the user with whatever changes might have been made
        log.debug("user before update: {}", currentUser);
        userDao.saveOrUpdate(currentUser);

        // update the user in the session
        User updatedUser = (User)userDao.getById(currentUser.getId());
        log.debug("user after update: {}", updatedUser);

        session.removeAttribute("user");
        session.setAttribute("user", updatedUser);

        resp.sendRedirect(req.getContextPath() + "/viewMyLog.jsp");
    }
}
