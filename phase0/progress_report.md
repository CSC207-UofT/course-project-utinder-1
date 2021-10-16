## Progress Report

### Tasks
#### Specification
- Our goal is to **create an Android app** that provides both academic and
  social assistance for the students at the University of Toronto (further addition of 
  other universities is possible for future expansion).

#### CRC model 
- We have created **14 different CRC cards**, and 12 cards were divided into three main categories: 
Event, Post, and User. 
  - The Event class and its subclasses (such as Course) will store the name, date, and title of the event. 
  - The EventManager are for creating, storing and deleting all the Event instances created. 
  - The EventsTable is for storing all events for a current week.
  - The Post class and PostManager will create and control any posts created by the user. 
  - The User class and its subclasses will store the users' nickname/username, email address, and password. 
  - The UserManager class is for creating and keeping track of the Users.
  - The UserData is used for storing all the Users registered to the app. 
- The rest of 2 cards are for converting the format of the dataset we're going to use and 
for displaying Graphic User Interface. 

#### Scenario Walk-Through
- For the first phase, we chose the situation in which the user tries to register and log in to the app. 
- In this scenario, after the user inputs their information (i.e. nickname, email, and password), the system will work with User, UserManager, and UserData classes for adding this newly created object to the system. 
- The expected output is a message of either "Sign in Complete" or "It's wrong". 

#### Skeleton program
- Based on the CRC card and Scenario Walk-Through, we created several Java Classes and the basic Graphical User Interface (Welcome page and log in page) for the Android app. 


### Open Questions
1. We had a problem of merging our changes to the main branch
2. We are considering to have several subclasses for User and Event
3. We had a problem putting the sign in icon onto the emulator
4. We are having a problem with uploading the android app to the main branch
5. We are also discussing what kind of database we should use for convenience. 


### Huge Success So Far
1. Our Android Emulator works well
2. The app design and the unittests are great and follow what we epxect to see. 
4. We all agree about how clean our code architecture is!


### Each Member's Contribution
All the members actively participated in the project. Specifically, 
Michael, Kex, and Rachel have been working on CRC Cards and Scenario Walk-Through
and Justin and Ellie have been working on the skeleton program. Aaditya have been 
working on trouble-shooting issues in code and overall review.
