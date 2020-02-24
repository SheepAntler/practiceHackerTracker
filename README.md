# Practice Hacker 

Elspeth's Independent Enterprise Java Project 

### Problem Statement 

As someone who's taught private violin lessons for many years, I know that the hardest part of learning
(and teaching!) an instrument is making regular practice a habit. Even as a working freelance 
performer, I find it difficult to maintain healthy practice habits amidst the chaos of my 
teaching and performing schedules. 

Most of my teaching colleagues have their students keep track of practice sessions on charts, whilst 
several of my symphony colleagues keep practice journals for themselves. These charts and journals serve 
as a way for both young and seasoned musicians to keep track of their practice habits, record 
what techniques work well for them, and to see how the frequency/duration of their sessions stacks up
to their peers' practice data. 

This got me thinking: there are loads of "personal trainer" apps out there--record your exercise, 
count your calories, measure your water intake, etc--and all of them share really meaningful attributes 
that make tracking a personal habit-building journey simpler. 

There are a couple apps like that for musicians, too--to hold you accountable to a practice schedule 
you commit to. An app where you can keep all of your practice ideas in one handy place. And here's the bit the DOESN'T exist yet: an app 
with which teachers can share practice ideas with students, and with which students can share 
progress with teachers. 

Life is bananas, and fitting in regular practice sessions can feel like a nigh-impossible task. 
Let's make it a little easier, eh? 

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data TOTAL! 
  * User (Teacher) role: create/read/update/delete all studio data
  * User (Student/Pro/Hobbyist) role: log personal practice sessions
  * All: anyone can view information about the application--why it exists, how it works, etc. Anyone can also view practice tips and tricks!
* Database
  * MySQL
  * Stores users and roles
  * Stores studio data for teachers--who is in a teacher's studio? 
  * Stores practice data/goals for students 
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * IMSLP--The Petrucci Music Library! Students can search for public-domain sheet music through this service. 
  * YouTube, perhaps? Students will be able to look up/listen to recordings of pieces they are working on. It might also be a distraction, though...
* CSS 
  * Bootstrap
* Data Validation
  * Bootstrap Validator/RegEx for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. 
* Hosting
  * AWS
* Independent Research Topic/s
  * Materialize
  * IMSLP/YouTube API
  * Project Lombok to streamline class-building. No more getters/setters!
* Unit Testing
  * JUnit
* IDE: IntelliJ IDEA


### Design

* [User Stories](DesignDocuments/userStories.md)
* [Screen Design](DesignDocuments/wireframes)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)


