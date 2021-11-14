# Design Document

### Specification
Briefly highlight any additional functionality that you have implemented between phase 0 and the end of phase 1.

In phase 0, we've shown what happens when the User creates a new account which will be managed by UserManager, then UserManager checks the account and gives the message whether the User successfully signed in or not. 
For phase 1, we've decided to put more functionality, such as how the User can interact in the Homepage, checks their schedules in the Event page, have their own page. Furthermore, we've added functionality for adding a new post on the Community feature. 

### Any major decision made
A description of any major design decisions your group has made (along with brief explanations of why you made them).

### SOLID
How well does your design adhere to the SOLID design principles?
- Give us specific examples of how your design adheres to the SOLID principles.
- If you found that something in your design wasn't good, tell us about that too!
  - Pretending part of your design is good — when you know it isn't — can potentially hurt your mark significantly!
  - Acknowledging bad design can earn you marks and demonstrates understanding — especially if you discuss how you could fix it if you had more time!

**Single Responsibility Principle**

### Clean Architecture
Is your program consistent with Clean Architecture?
- Show us with something like a CRC model or UML diagram.
- Describe a scenario walk-through and highlight how it demonstrates Clean Architecture.
- Are there any clear violations if we were to randomly look at the imports in a few of your files?
- Is the Dependency Rule consistently followed when interacting with details in the outer layer?
  - Give us a concrete example from something like your UI or an interaction with a database.


**UML Diagram**

**Scenario Walk-Through (demonstrating Clean Architecture)**

**Violations**

**Dependency Rules**

ex. MainActivity -> UserManager


### Design Patterns
Has your group used design patterns in appropriate places in the code? Identified and described any patterns that could be applied in future with more time?
- Have you clearly indicated where the pattern was used and possibly pointed out which Pull Request it was implemented in?
- Be careful that there aren't any obvious places a design pattern should have been applied that your group forgot to mention.

### Packaging Strategies
A brief description of which packaging strategies you considered, which you decided to use, and why.

We decided to use the 'packaging by layer' strategy since we have distinct pages for each layer. 

### Use of Github Features
Did your group make an effort to use some of the various features of GitHub to facilitate development of your code?
- Issues?
- Actions?
- Pull Requests?

We've mostly used Pull Requests as we worked on different branches for each person and then merged later after 
discussing with other people. 


### Code Style and Documentation
Are there any warnings when the code is opened in IntelliJ?
- Fix them as you go!
Is Javadoc used where needed?
- Document as you go!
If a Java programmer were to open your repo and navigate to a random file, would they be able to understand your code?
- Review each other's Pull Requests as you go!

### Testing
Are most components of your system tested? Are there any components that would be difficult to test due to your design?
- We know time is tight in the project, so it is fine if you don't test everything if your group decides to focus on other aspects of the program, but we want to see evidence of testing.
- A significant portion of your code should be tested to earn full marks for this (run your tests with coverage to check).

### Refactoring
Is there evidence that your team has refactored code in a meaningful way during the project?
- Point to specific Pull Requests!
- This could even be applying a design pattern to code you wrote in phase 0!
Are there any obvious code smells still in your code that you missed fixing?

### Code Organization
Is your code organized in a meaningful way? Is it easy to find things in your package structure?
- Tell us about how you decided to organize your code and why!

### Functionality
Does your program do what the specification says it should do?
- Demo your program's functionality to your TA or make a short video!
- Is the functionality sufficiently ambitious, given the size of your group?
Can your program store state and load state? I.e. Can the state persist across runs of your program?

### A progress report
- open questions your group is struggling with
- what has worked well so far with your design
- a summary of what each group member has been working on and plans to work on next
