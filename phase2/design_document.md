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
### Single Responsibility Principle
Single Responsibility Principle states that there should be only one actor in each class, or equivalently, there should be only one reason to change. Our project clearly depicts this principle. All the activity classes that relate to the User Interface only take care of those details in the UI. Entities classes, such as `User`, `Event`, and `Post`, are only responsible for dealing with a single of object of those types. 

### Open/Closed Principle
`Event` class represents Open/Closed Principle in which all the subclasses share the same behavior, so we only needed to implement methods in the parent class, which later helps to extend more types of events by any chance. In addition, as those different types of events share the same behaviour in general, it also satisfies the Liskov Substitution Principle. 

### Liskov Substitution Principle
Even though we did not implement interfaces in our project, but using inheritance, our project performs LSP. For instance, all subclasses in `Event` class follow operations that `Event` class do. 

### Interface Segregation Principle
In our project, we did not implement any interfaces, but only used the inheritance. And all of subclasses actually depend on all the methods from their parent class. So we conclude that ISP is not applicable in our project. 

### Dependency Inversion Principle
Dependency Inversion Principle tells us that high level modules should not depend on low level modules, such as user interface. As this principle is tightly related to Clean Architecture, and as we did not violate any dependency rules in clean architecture, our project follows DIP. 

## Clean Architecture
Our project clearly follows the clean architecture as shown in the [diagram](https://github.com/CSC207-UofT/course-project-utinder-1/blob/5b797fa09ec5d77cb94173a0140e5b7acdae9b8a/phase2/clean%20architecture%20simple%20diagram.jpg). For the outer layer, we have Android application with corresponding its Activity classes and Firebase. To make an interaction between the infrastructure layer and application layer, we made some data converter classe which is located in Adapter layer. Then for Use Case, there are three manager classes, `UserManager`, `PostManager`, `EventManager`. Lastly, Entities layer consist of various classes of `User`, `Post`, and `Event`. 

### Scenario Walk-Through for Clean Architecture
**When the User signs in**
1. The User starts to run the app, and Welcome screen page will be displayed. 
2. After a few seconds, the User sees the Sign-in page, in which they need to type their email address and the password. 
3. After the User types the information, the `MainActivity` class (an activity class for Sign-in page) will call `UserDataConverter` to check whether their email address and password are correct by passing the information to it. 
4. This `UserDataConverter` will then call and pass these information to `UserManager`, which will check whether everything is correct. 
5. If everything is correct, then `true` value will be returned, which will be used by `UserDataConverter` and `MainActivity` sequentially.
6. After receving the success sign, `MainActivity` will call a method to display `Homepage`. 

## Design Pattern
**--Post-related classes--**

In phase 2, we connected post and its related classes to our database, so that whenever a user makes a new post, the post will be updated to
the database and added to the community page. Then, when visualizing all the posts dynamically in order of posting time, we need to use the
list view feature in android studio, which takes a list of strings and a specified layout. However, we retrieve our data in the database in 
form of map, which maps from the title of the post to the post object itself (the customized object). At this point, to make our data usable
for visualizing, we applied the adapter design pattern as a middleman to fit our data into proper layout of the community page, which enables 
the visualization of our app.

**--Event-related classes--**

In phase 2, we applied the Simple Factory method design pattern in creating new `Event` class in our project. We decided to use this particular design pattern
because different types of events are sharing some common features. And this Factory design pattern provided a simpler implementation compared to other design
patterns, such as the Builder design pattern. 


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

## Testing

**--User-related classes--**
For User, we have testing being able to create new users, along with logging in and ensuring all the data is being saved to the database.

**--Event-related classes--**
For Event, we have tested creating events, adding events and removing events with units tests like Event Creation Fail or Success, Course Creation and Removal Fail or Success, Assignment/Exam/Extra Homework Creation Fail or Success as well.

**--Post-related classes--**
For the posts, there are unit tests to create, delete, edit, comment, like such as create post test, delete post test, edit post test, make comment and more. Some of the tests required the database to work and we had to check if the new data being entered was successfully being tranferred or not.

For the rest of the app, we were able to test by usage and comparing with the database such as Login, Sign Up, Pomodoro, and various other sections. Ee were able to simply run those seperately continuously such as the Pomodoro, which was tested through actual usage.

## Refactoring
One of the biggest change was establishing and linking most of the data to the databse. 

**For Post**, we were able to link all of the posts to Firestone. There was a also a change in the way Comment for Post was implemented. Comments for a Post used to be Post Objets but now it is individual. Comments were changed to be a map with three keys (Text, Mentions, TextID).

**For Events**, there were various new packages that were added to Event and EventTest for the user to better input in their event, which can be assignment, exam, extra work and more. 

New implementation of the Pomodoro Timer which is a study focus timer, which can be found on the bottom navigation bar. 

New implementation of Task from the homepage where users can add short-term tasks such as TO DOs that they can add and remove smoothly.

Lastly, we repackaged all the files in each page into the specific layer of the clean architecture to understand their relationship. 

## Functionality
For the phase 2, we connected various features and database together. For each page in our app, we've added the following features/functions for the better app performance:

### Homepage
* Added a feature for adding tasks that the User needs to complete with checkbox and connected to the database

### Event
* Added the ability to display the popup window for all the events on the selected date
* Connected to the FirebaseAuth to get the current user and extract only their data

### Community
* Added a feature for making post, comment post, and comment on comments, and this functionality is one of the biggest tasks we've done for phase 2

### Pomodoro
* Created a page for showing the Pomodoro timer, in which the user can adjust the time interval for the study and break time

### My Account
* Added a feature for showing the list of followers and followings


## Progress Report

### Summary of each member's contribution
| Member  | Contribution |
| ------------- | ------------- |
| Justin Cha | Finished error handling for the login classes. Linked up user authentication for higher security. Changed the way data is stored for user credentials. Made unit tests for the login classes. |
| Aaditya Mandal  | Designed and implemented the Pomodoro Timer to the application, along with assisting Ellie with the UI of the homepage such as adding tasks. Increased security level for the database by adding the authentication email per user when they sign up.|
| Michael Rubenstein  | Created / fixed basic UI for viewing posts and comments, implemented functions to show the data in the UI, implemented unit tests, collaborated with kex in design and implementation of connecting posts to firestore. | 
| Kex Zhang  | Designed and implemented the community page, making post page, view post page, reply post page, view comment page, reply comment page, and update the posts to database with Micheal. |
| Ellie Kang  | Modifying homepage view (added the functions for adding tasks and pomodoro stuff), Fixed UI for posts and comments from Michael and Kex. Added some necessary functions for logging out and renewing bottom navigation. |
| Rachel Seong  | Implemented a popup window of showing the list of events on the selected date, Designed other user???s Profile page, Implemented the code for controlling following/follower features |

### Summary of each member's Pull Requests
Each group member should include a link to a significant pull request (or two if you can't pick just one) that they made throughout the term. Include a sentence or two explaining why you think this demonstrates a significant contribution to the team. 

| Member  | Pull Request |
| ------------- | ------------- |
| Justin Cha | The pull request I am proud of is [https://github.com/Bantonio12/Utinderlogin/pull/11] where I was able to connect the authentication feature to its full by adding username to the each user profile and adding more security features regarding user verfication. Also I was able to add the user email verfication functionality. This has allowed us to send emails to new users and ask them to verify their email. Hence reducing the number of spam and fake accounts. Also I added a password reset function so that the user can reset their password when needed. | 
| Aaditya Mandal  | The best pull request for me was [https://github.com/Bantonio12/Utinderlogin/pull/10], where we were able to modify homepage to get a working tasks section so that the user can input and remove tasks smoothly. Also modified the greeting to be based on the time of the day. Overall homepage was finalized during that pull request and it came out to be really nice at the end. |
| Michael Rubenstein  | The pull request that I'm proud of is https://github.com/Bantonio12/Utinderlogin/pull/6 in which Kex and I refactored the entire Post related classes to make it adhere better to Clean Architecture, deleted useless code , changed the Java Docs and added more unit tests. |
| Kex Zhang  | The pull request that I'm proud of is https://github.com/Bantonio12/Utinderlogin/pull/3, in which I updated the basic functionality of community page, including making post, viewing post, commenting post, and commenting on comment, while updates the corresponding information to firestore database. |
| Ellie Kang  | (I was having rolling back issue in Github so I passed the files to Rachel and she did the pull request for me.) One of the jobs I am proud of the most is https://github.com/Bantonio12/Utinderlogin/pull/4. I used the basic UI tool from Aaditya and fixed the basic UI design. I also implemented adding task function as we planned. Rachel was helping me to resolve the errors in homepage.java.  |
| Rachel Seong  | One of the pull requests that I'm proud with is [Pull request #7](https://github.com/Bantonio12/Utinderlogin/pull/7). In this request, I was able to extract only the data of the user who is currently signed in this app, which indeed extended our functionality. Furthermore, doing some refactoring in the code made the entire project look more efficient.|

## Accessibility Report
For each Principle of Universal Design, write 2-5 sentences or point form notes explaining which features your program adhere to that principle. If you do not have any such features you can either:

(a) Describe features that you could implement in the future that would adhere to principle or

(b) Explain why the principle does not apply to a program like yours.

1. Principle 1 : Equitable Use
 - All features are accessible to all users no matter whether they are Students or Faculty

2. Principle 2 : Flexibility in Use
 - Pomodoro timer is adjustable, so users can set their own preference
 - Events section is fully customizable, users can add their own schedule into the events
 - Button sizes are adequate size to facilitate the users accuracy and precision

3. Principle 3 : Simple and Intuitive Use
 - UI design is easy to understand and find functions, first button: homepage, second button: events, third button: posts, fourth button: Me
 - Toast popups to show successful event creation / posting / login

 - Parts that did not follow well: 
    - Posts needs to arrange posts by posting time
    - App only has English

4. Principle 4 : Perceptible Information
 - Choice of colours for features such as buttons / app text helps maximize ???legibility??? (the quality of being clear enough to read)
 - Color choice also provides adequate contrast to the text and all of its surroundings (for example black on white good,  yellow on white bad)
 - The add post button uses ???+??? which intuitively represent add post which replaces the redundant presentation of ???add post???

5. Principle 5 : Tolerance for Error
 - Events provided Toast warning to show whether or not the events were created successfully / unsuccessfully
 - Posts provided Toast warning to show whether or not the posts were successfully posted and whether or not the posts were unsuccessful
 - Posts wouldn???t create posts if there was no title as it would break the database since the titles are the key for the databases

6. Principle 6 : Low Physical Effort
 - Events moved the create event and cancel buttons onto the bottom of the screen in order to minimize finger travel distance
- Posts provided well Low physical effort in replying to posts, where the text input bar is lower down to the bottom of the screen to reduce finger movement


7. Principle 7 : Size and Space for Approach and Use
 - We did not implement this principle well. Most of our button sizes are set however their location is relative to the size of the screen
 - If the user had smaller hands and a bigger screen, it might be hard to reach some of the buttons that are further away


Who Would You Market Your Program Towards?
- Our program will be marketed towards but not limited to University of Toronto Faculty and Students. We hope to expand our application in the future to encompass more university campuses. The app is an all in one socialization / organizational app for people who have any stake in University of Toronto.


Any Demographics that Would Less Likely Use Your Program?
- Our program most likely won???t be used by people that are outside of / have no affiliation with University. The app is targeted for University stakeholders and can only be logged onto by people who have email addresses affiliated with a university. Therefore most / if not all users will be people who have university affiliation.


## Extension
After finishing the project, we reflected and wrote down the list of features that we can add in the future. 
In general, we first thought it would be good to expand to other university students. And we can possibly add group chat functions. Then, for the User side, they might want to set profile pictures which require the larger storage for the database. Then, for the Event, it would be great to add functionality of filtering the events based on its types or corresponding courses. And we can let the user to edit some of the events, which might possibly require the Observer design pattern. Then, for the Community page, it would be great to enable features to comment on comments and apply factory design pattern when reply to post or comment. 

