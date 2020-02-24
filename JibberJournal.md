# Jibber Journal

### A Journal for My Jibberish

## Date 
1/28/20 

### FUN WITH DATES
As usual, I made this as hard has possible, so I wanted to drop a couple links/thoughts here so I never ever spend more than 10 minutes down that rabbit hole again. It's dark, and it's profoundly un-fun.

What did we learn (again)? 
* NEVER USE util.Date. EVER. IT SUCKS AND NOBODY WANTS IT. It's old and stupid. 
* Joda-Time sounds cool and all, but why read a bunch of documentation about it when the java.time API is just as excellent, and less of a pain to set up? 

What can we do with java.time? 
* Not feel generally foolish trying to remember which date class is deprecated
* Calculate the difference between two times: 
   * https://stackoverflow.com/questions/27005861/calculate-days-between-two-dates-in-java-8
   * https://www.leveluplunch.com/java/examples/number-of-years-between-two-dates/
* FEAST YOUR EYES ON THE REST HERE: https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html 

### Finally, do we have questions? 
Well, yes, but not about dates right meow. 

* Can I still access the 1st-semester Java website? I want to do some review regarding how to compile/run java code without scripts or Maven to help me. I'm rusty! 
* After reading about Joda-Time with a bit more knowledge, I'm realizing that I have a couple of sticking points I need to research further: 
   * Okay. So, the classpath--I thought I understood it better than I do. I understand I need to add stuff to it to get it to work when I'm running .sh scripts, but how does that work when we're using Maven to do our builds? Also, "add stuff to it to get it to work"? Those aren't the words of someone with profound understanding. 
   * DEPENDENCIES. What? I need to read up on this. When I was on the Joda-Time site, I saw that it has a dependency I need to use it with Maven. Do I copy-paste that into my pom.xml file, or what? Do I need to worry about making sure libraries like Joda-Time are on my classpath when I'm using Maven (or other bits and bobs of that ilk)?

These questions might be the ravings of a tired mind. But I'll bet there's at least a shred of valid misunderstanding somewhere in there.

Here are resources for the future: 
* https://docs.oracle.com/javase/7/docs/technotes/tools/windows/classpath.html
* https://howtodoinjava.com/java/basics/java-classpath/
(I'm beginning to get a better grasp--.jars (like the one I would download from Joda-Time) live in a /lib directory and THAT goes on the classpath in the .sh script used to run a program...it can go in there with a *.jar wild card operator. YES. That's it. Then the compiler knows where to look for packages and the like.)

## Date
1/31/2020

### log4j
Order of valid levels of importance in log4j (from most messages displayed-least)
* (ALL)
* TRACE
* DEBUG
* INFO
* WARN
* ERROR
* FATAL
* (OFF) - although the log statements apparently still execute at this level

You can also do: 
Logger.getRootLogger().setLevel(Level.off);
(but I _think_ this is just if you're not using a properties file to control the logger)

## Date 
2/3/2020

### JUnit 
IDEALLY, each unit test should perform ONE TASK. In your current ListTest class for Exercise 3, you have some assertTrue + assertEquals assertions in the same tests, but in the future you could split those out into their own tests. 

## Date
2/8/2020

### Wireframes 
I wasn't sure whether finishing up my wireframes before my other design documents were done was a good idea, but now that I've gotten through them, I'm incredibly glad I chose to complete them when I did. The whole process really got me thinking about my MVP--something about dragging all those rectangles around on webpage after webpage really helped me draw a better-defined line in the sand between what I _know_ I'm going to be able to complete (and how I would go about completing it) and what my reach items are going to be. I'm going to make a markdown table that outlines my MVP items and my reach items right after I'm done with this reflection, while it's all still fresh in my mind. 

## Date

### Entity Relationships 
BLOCKER TIME. I'm bamboozled. In my application, there are two roles: "teacher" and "not teacher". Many users can have each role, but each user can only have one role per account. That's totally a One-To-Many relationship--however, here's where the wheels pop off for old Elspeth: 
1. Why do I need IDs for my roles if there are only 2 of them? 
2. If the foreign key is on the "one" side (in my case, the *roles* side), then how do I annotate that? I did a BUNCH of research on this, and tried something out that ultimately didn't work. I _have_ picked up that this makes it a Unidirectional One-To-Many relationship instead of a Bidirectional one (which is the sort we've been discussing), but I'm unclear on how to mark out the difference in my Hibernate annotations correctly--especially since some folks online seem to be VERY disparaging when it comes to unidirectional one-to-many relationships. I feel harshly judged by a lot of Stack Overflow users, to be honest. 

Also, one other question: I know that we're using the username field in both Users and Roles for authentication; however, I'm confused about how that ties in to the One-To-Many relationship. Are we required to use the username field as our foreign key in the roles table? Or can we use ID like the demo/exercise 5? 




   
  

