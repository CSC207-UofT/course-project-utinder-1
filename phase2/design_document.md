# Phase 2 Design Document
## Specification
For this project, we would like to create an Android app that provides both academic and social assistance
for the students at the University of Toronto.

  * When we start to run the project/app, the Welcome page will be shown, and after 3 seconds, we can see the Sign-In page.
  * The user needs to use their corresponding UT email, their username and password for authentication.
  * After a successful login to the app, the user will be able to see the main page consisting of all accessible menus.
  * In the *Home/Main Page*, the User can check the list of tasks they need to complete. 
  * In the *Events* menu, the User can see the calendar in which they can see the coloured dots under each date if there is an event and check the details of all events on the selected date
  * In the *Community* tab, the User can use the following features:
    * Post about anything they want to share
       * They can also anonymously post it!
    * Ability to like/unlike posts
    * Leave comments under any post
  * In the *Pomodoro* page, the User can use the pomodoro timer which helps them to focus on tasks by the specific time interval with taking enough rest
  * In the *My Account* page, the User can keep track of Users that User is currently following and other Users who follow this particular User

## SOLID
Our project mainly consists of the following principles: Open/Closed Principle. 

`Event` class represents Open/Closed Principle in which all the subclasses share the same behavior, so we only needed to implement methods in the parent class, which later helps to extend more types of events by any chance. In addition, as those different types of events share the same behaviour in general, it also satisfies the Liskov Substitution Principle. 


## Clean Architecture



## Design Pattern
**--Post-related classes--**

At first, we were following the composite design patter and implemented an abstract class called Post for giving the
structure to posts, then a class called MainPost that extended from it, and another class called Comment.
The idea was that MainPost and Comment were essentially the same, but you are unable to add a title for Comment and
are only able to reply to MainPosts / Comments with Comment. However, after discussing the code structure with
teammates we realized that since we are able to comment under comments, it didn't make sense to implement the
composite design pattern for this case as we don't have a leaf case. We realized that it would be much easier to read
and be less cluttered if we had only one class for all posts, then have an overloaded constructor to determine which
post contains a title and which post doesn't. This made the code much simpler and easier to understand.

**--Event-related classes--**

In phase 0, we were planning to have Event as a parent class and Course as a subclass. However, as there is no "is a" relationship,
we decided to have the following classes as subclasses of Event:
- General Event (e.g. Meeting, Extracurricular Event) is a personal event (not related to the course the User is taking)
- Course Event (e.g. Assignment, Exam, Others) is an event that is related to the specific course that the User is currently taking

Because this change lets us more easily understand the relationship between the classes, we decided to make the decision as above. 

Furthermore, when we needed to apply the Simple Factory method design pattern, it was quite hard to come up with which parameters should be called.
But by distinguishing the common features and different features among the subclasses of Event, we decided to come up as the current version.

By now, we applied the Simple Factory method design pattern in creating new `Event` class in our project. We decided to use the particular design pattern
because of the common features that different types of events share (as mentioned in the section **Major Design Decision** above). And this Factory design pattern provided 
a simpler implementation compared to other design patterns, such as the Builder design pattern. 

**--User-related classes--**



## Use of Github Features
We've mostly used Pull Requests as we worked on different branches for each person and then merged later after
discussing with other people. Besides Pull Request, we had a chance to use the direct "Resolve Conflicts"
feature in Gitub via web editor. This tool helped to see in which area there was a conflict between the local
branch files and the main branch files.

## Code Style and Documentation
### Packaging Strategies
We decided to use "package by feature" strategy to indicate different pages in the app that the User can click and see. 
While we considered using "package by insider/outsider", it was much better to have all the classes related to one feature together 
to easily interact with each class. 

### Code Organization

## Testing
**--User-related classes--**

**--Event-related classes--**

**--Post-related classes--**

## Refactoring


## Functionality



## Progress Report

### Summary of each member's contribution
| Member  | Contribution |
| ------------- | ------------- |
| Justin Cha |  |
| Aaditya Mandal  | |
| Michael Rubenstein  | |
| Kex Zhang  | |
| Ellie Kang  | |
| Rachel Seong  |  |

### Summary of each member's Pull Requests
| Member  | Pull Request |
| ------------- | ------------- |
| Justin Cha |  |
| Aaditya Mandal  | |
| Michael Rubenstein  | |
| Kex Zhang  | |
| Ellie Kang  | |
| Rachel Seong  |  |

## Accessibility Report
For each Principle of Universal Design, write 2-5 sentences or point form notes explaining which features your program adhere to that principle. If you do not have any such features you can either:

(a) Describe features that you could implement in the future that would adhere to principle or

(b) Explain why the principle does not apply to a program like yours.

1. Principle 1 : Equitable Use
2. Principle 2 : Flexibility in Use
3. Principle 3 : Simple and Intuitive Use
4. Principle 4 : Perceptible Information
5. Principle 5 : Tolerance for Error
6. Principle 6 : Low Physical Effort
7. Principle 7 : Size and Space for Approach and Use

Who Would You Market Your Program Towards?


Any Demographics that Would Less Likely Use Your Program

