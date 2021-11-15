# Design Document

### Specification
*Briefly highlight any additional functionality that you have implemented between phase 0 and the end of phase 1.*

From the phase 0, we had the specification as following:

From this project, we would like to create an Android app that provides both academic and social assistance
for the students at the University of Toronto.
  * When we start to run the project/app, the Welcome page will be shown, and after 3 seconds, we can see the Sign-In page.
  * The user needs to use their corresponding UT email, their username and password for authentication.
  * After a successful login to the app, the user will be able to see the main page consisting of all accessible menus.
  * In the *Events* menu, the user can find the following features:
    * EventsTable - Where users can upload courses, events and deadlines to create a sharable timetable with other users
    * Post any questions about the enrolled courses
    * Manage deadlines for all upcoming assignments / tests for any courses
  * In the *Community* tab, the user can use the following features:
    * Post about anything they want to share
       * They can also anonymously post it!
    * Ability to like/dislike posts
    * Leave comments under any post

For phase 1, we decided to modify and extend the following things:
- In the main **homepage** after log in, the User can check the list of tasks they need to complete. And they can use the 
*Pomodoro* timer which helps them to focus on tasks by the specific time interval with taking enough rest.
- In the *Event* menu, the User can see the calendar with the dots indicating the events on the specific date.
- The User can "unlike" posts, not "dislike" posts.

### Major Design Decision
*A description of any major design decisions your group has made (along with brief explanations of why you made them).*

During the phase 1, there was an active discussion regarding the design of our app with related Java classes.

**--Changes in Post-related classes--**

At first, we were following the composite design patter and implemented an abstract class called Post for giving the
structure to posts, then a class called MainPost that extended from it, and another class called Comment.
The idea was that MainPost and Comment were essentially the same, but you are unable to add a title for Comment and
are only able to reply to MainPosts / Comments with Comment. However, after discussing the code structure with
teammates we realized that since we are able to comment under comments, it didn't make sense to implement the
composite design pattern for this case as we don't have a leaf case. We realized that it would be much easier to read
and be less cluttered if we had only one class for all posts, then have an overloaded constructor to determine which
post contains a title and which post doesn't. This made the code much simpler and easier to understand.

**--Decision in adding more Event-related classes--**

In phase 0, we were planning to have Event as a parent class and Course as a subclass. However, as there is no "is a" relationship,
we decided to have the following classes as subclasses of Event:
- General Event (e.g. Meeting, Extracurricular Event) is a personal event (not related to the course the User is taking)
- Course Event (e.g. Assignment, Exam, Others) is an event that is related to the specific course that the User is currently taking

Because this change lets us more easily understand the relationship between the classes, we decided to make the decision as above. 

Furthermore, when we needed to apply the Simple Factory method design pattern, it was quite hard to come up with which parameters should be called.
But by distinguishing the common features and different features among the subclasses of Event, we decided to come up as the current version.



### SOLID
*How well does your design adhere to the SOLID design principles?*
- Give us specific examples of how your design adheres to the SOLID principles.
- If you found that something in your design wasn't good, tell us about that too!
  - Pretending part of your design is good — when you know it isn't — can potentially hurt your mark significantly!
  - Acknowledging bad design can earn you marks and demonstrates understanding — especially if you discuss how you could fix it if you had more time!

Even though our codes do not reflect all of five SOLID principles, we believe that we still have good examples that satisfy some of them. 
For instance, Event class represents Open/Closed Principle in which all the subclasses share the same behavior, so we only needed to implement methods in the parent class, which later helps to extend
more types of events by any chance. In addition, as those different types of events share the same behaviour in general, it also satisfies the Liskov Substitution Principle. 

However, we think that there should be an improvement in Dependency Inversion Principle. For instance, for the CourseManager, since it needs to work with three types of events (e.g. Assignment, Exam, Others), 
it might be good to rather create the parent class of "CourseEvent" for those three subclasses and work with that class directly for much simpler use. 


### Clean Architecture
*Is your program consistent with Clean Architecture?*
- Show us with something like a CRC model or UML diagram.
- Describe a scenario walk-through and highlight how it demonstrates Clean Architecture.
- Are there any clear violations if we were to randomly look at the imports in a few of your files?
- Is the Dependency Rule consistently followed when interacting with details in the outer layer?
  - Give us a concrete example from something like your UI or an interaction with a database.

The **UML Diagram** for the entire project can be found in `phase1/UML Diagram` directory in the main branch of our repository. 

**Scenario Walk-Through (demonstrating Clean Architecture)**

The `User` creates a new account, `ActivityRegisterGui` (i.e. a Java class for UI) will call the database to add a new data and calls
`UserDataConverter` (a name of FormatConverter class for User) which will interact with `UserManager` class for updating the data. 


**Violations & Dependency Rules**

During the middle of progress, we actually had a moment of violating the Clean Architecture. When we needed to send the newly created event to EventManager from the UI-related java class, 
instead of using the middle man (FormatConverter), we directly called EventManager, which is indeed Use Case class. So, we quickly created the class for one of FormatConverter classes to pass the data to EventManager. 
This violation was actually found when we add a new User data from the UI to the UserManager. 

For reference, `CreatingEvent` class initially had a violation of Clean Architecture inside the method of `onCreate()`.
But as a solution, we created `EventDataConverter` which instead calls `addNewEvent()` to add the data to the EventManager.



### Design Patterns
*Has your group used design patterns in appropriate places in the code? Identified and described any patterns that could be applied in future with more time?*
- Have you clearly indicated where the pattern was used and possibly pointed out which Pull Request it was implemented in?
- Be careful that there aren't any obvious places a design pattern should have been applied that your group forgot to mention.


By now, we applied the Simple Factory method design pattern in creating new `Event` class in our project. We decided to use the particular design pattern
because of the common features that different types of events share (as mentioned in the section **Major Design Decision** above). And this Factory design pattern provided 
a simpler implementation compared to other design patterns, such as the Builder design pattern. 


### Packaging Strategies & Code Organization
*A brief description of which packaging strategies you considered, which you decided to use, and why.*

We decided to use "package by feature" strategy to indicate different pages in the app that the User can click and see. 
While we considered using "package by insider/outsider", it was much better to have all the classes related to one feature together 
to easily interact with each class. 

For code organization, as Android app already distributes the files into different folders, we were able to easily keep track of which class files are in which directory.

### Use of Github Features
*Did your group make an effort to use some of the various features of GitHub to facilitate development of your code?*

We've mostly used Pull Requests as we worked on different branches for each person and then merged later after
discussing with other people. Besides Pull Request, we had a chance to use the direct "Resolve Conflicts"
feature in Gitub via web editor. This tool helped to see in which area there was a conflict between the local
branch files and the main branch files.

### Refactoring
*Is there evidence that your team has refactored code in a meaningful way during the project?*

We decided to delete UserData and EventTable as the purpose of these classes were overlapped with UserManager and EventManager. 
Furthermore, we initially had 4 classes related to Post, but now we have 2 classes (`Post` and `PostManager`) as explained in **Major Design Decision** section above.


### Functionality
*Does your program do what the specification says it should do?*

We have completed to implement the UI for logging in and seeing the homepage, mostly finished with showing Pomodoro timer in the homepage and 
showing the events in the Calendar. And we have basic features for Community page and Me page. 

### A progress report
#### Open Questions of Struggle
*open questions your group is struggling with*
- We are now questioning whether Posts should contain pictures as our database has a 5 GB limit on storage. Therefore, including pictures might take up too much space.
- We need to find the efficient answer for where to display timetable and add the specific courses that the User is taking for the semester.
- Rachel has the following concerns:
  - whether to create GeneralEvent and CourseEvent as parent classes or directly have 5 different events as subclasses. 
  - how to update the newly created `Assignment, Exam, Others` to the CourseManager. 

#### Success
*what has worked well so far with your design*
- We have been able to push the android app to the main branch
- The recursive structure for Posts seem to work fine with all the testing so far.
- We finally set up the firebase for the app. 

#### Summary of each member's contribution
*a summary of what each group member has been working on and plans to work on next*

| Member  | Description |
| ------------- | ------------- |
| Justin Cha | Content Cell  |
| Aaditya Mendel  | Content Cell  |
| Michael Rubenstein  | Designed the structure and collaborated on the implementation for Post and Post related classes with Kex. Cleaned up structure, and fixed potential errors for Post. Added unit testing for Post to find bugs and see if it behaves according to our design.|
| Kex Zhang  | Content Cell  |
| Ellie Kang  | Designed gui for each required screen (registration view, registration success view, homepage view, calendar view (rachel helped me a lot), event view, creating event view and me view); modified Java class for the functionality of the screen component.  |
| Rachel Seong  | Implemented the Event-related classes; made an interaction between Java class for UI to the Event classes; plan to add the functionality for each different User with their own Event data; Created UML Diagram|
