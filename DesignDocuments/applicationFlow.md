# Application Flow

### Practice Tracking, FAQ

1. Static HTML pages; user does not need to be logged in to view these pages. 
* Practice Tracking = Info about what the application _does_
* FAQ = Answers questions for folks who are thinking about using the app (also available for logged in users of both types)


### Hacks
1. Static HTML page with generic samples of practice tips/tricks when user is *NOT* logged in.
2. Dynamically generated based on a Practice Hacker's level of proficiency once user *IS* logged in.


### User Sign-Up 

1. User selects "sign up" icon (visible to all users who aren't already signed in).
2. User can choose to create a "Teacher" account or a "Practice Hacker" account.
3. User fills out a form and submits it. 
	* Teacher form: personal information and studio information
	* Practice Hacker form: personal information/instrument/level/etc
4. If the username isn't already taken and all fields are filled out correctly, a request goes to sign-up servlet. 
5. Sign-up servlet creates the appropriate type of user object and saves it in the correct database. 
6. JSP displays a success message to the user. 


### User Sign-In

1. User selects the "sign in" icon (visible to all users who aren't already signed in) 
2. User enters username and password on the sign in form and submits it. 
3. If the user's password matches the encrypted password in the appropriate database, they will gain access to view/edit pages. 
4. If the user is not authenticated, display and error message and prompt them to try again or SIGN UP. 


## NOTE: HENCEFORTH, ALL FUNCTIONS ARE FOR SIGNED-IN USERS ONLY!


### Practice Hacker View Log/Teacher View Individual Student Logs

1. Page sends a request to view the user's individual practice log.
2. A practiceLog DAO is used to find that user's practice information.
3. The DAO runs a SELECT query and returns all of the user's practice data. 
4. The Servlet sends the user's practice data back to the practice log JSP. 
5. The user's practice data is displayed in a table on the JSP--probably limited to 5-10 results at a time (but the user can control this and view all results if they like) 


### Teacher Homepage View

1. Page sends a request to view studio practice data for a teacher's students. 
2. A studioLog DAO is used to find that teacher's studio data. 
3. The DAO runs a SELECT query and returns all of the teacher's students + their practice totals.
4. The Servlet sends the teacher's studio data back to the practice log JSP. 
5. The teacher's studio data is displayed in a table on the JSP.


### Practice Hacker Log New Session (Teacher's "Create Hack" and "Comment" abilities will function similarly)

1. User enters practice data into a form on the Log Writer JSP. 
2. On "submit", the DAO runs an INSERT query and enters the user's data + an auto-generated date into the Log table. 
3. The student's practice counter is updated in the User table as well. 
4. The JSP displays a "Success"/"Fail" message once the INSERT is performed 


### Set Practice Goals 

1. User selects a practice challenge to attempt from a drop-down menu on a JSP form. 
2. On "submit", the DAO runs an UPDATE on the user, setting their "goal" column to the selected value. 
3. The DAO also creates a new row in the goals table, beginning the user's practice count. 
4. Each time the user logs a session, the DAO updates both their goal data and their overall log data. 


### Practice Hacker/Teacher search for music 

1. The user enters a search term into an input field on the JSP. 
2. The search term is passed to the IMSLP API through a Servlet.
3. The Servlet hands the IMSLP results back to the JSP. 
4. If the search was successful, the JSP outputs the results. Otherwise, an error message is displayed. 







