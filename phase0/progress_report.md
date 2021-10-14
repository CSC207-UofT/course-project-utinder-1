## Progress Report

### Tasks
#### Specification
- Our goal is to **create an Android app** that provides both academic and
  social assistance for the students at the University of Toronto.

#### CRC model 
- We have created **14 different CRC cards**, and 12 cards were divided into three main categories: 
Event, Post, and User. 
  - The Event class and its subclasses (such as Course) will store the name, date, and title of the event. 
  - The EventManager and EventsTable are for storing all the Event instances created. 
  - The Post class and PostManager will create and control any posts created by the user. 
  - The User class and its subclasses will store the users' nickname/username, email address, and password. 
  - The UserManager and UsersTable are used for storing all the Users registered to the app. 
- The rest of 2 cards are for converting the format of the dataset we're going to use and 
for displaying Graphic User Interface. 

#### Scenario Walk-Through
- For the first phase, we chose the situation in which the user tries to register and log in to the app. 
- In this scenario, when the user gives their information (i.e. nickname, email, and password), then the system will 
work with the classes such as User, UserManager, and UsersTable for adding this newly created object to the system. 
- The expected output is that the user will see the page, which says that they successfully registered/logged in. 

#### Skeleton program
- Based on the CRC card and Scenario Walk-Through, we created several Java Classes and the basic GUI for the Android app. 


### Open Questions
1. We had a problem of merging our changes to the main branch
2. We are considering to have several subclasses for User and Event


### Huge Success So Far
1. Our Android Emulator works well (Ellie's M1 macbook got solved)
2. We still successfully merged our files
3. We all agree about how clean our architecture is!


### Each Member's Contribution
All the members actively participated in the project. Specifically, 
Michael, Kex, and Rachel have been working on CRC Cards and Scenario Walk-Through
and Justin and Ellie have been working on the skeleton program. 