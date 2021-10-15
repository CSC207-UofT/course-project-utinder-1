## Scenario Walk-Through

From this Scenario Walk-Through, we would like to mainly test User, UserManager, and UserData classes when the user registers to the app/log in to the app. 

In the beginning, the User will see the "Welcome to UTinder" page, and they need to click the button "Get Started". 
Now, from this step, the User will follow either case 1 or case 2 scenarios. 

#### Case 1
When the User tries to register to the app, the User needs to
* type their UT email, password, username
* declare their status: Student, Faculty, or Guest

By receiving the user information, the UserManager will create an account
for the user and add the newly created User to UserData.

If they successfully register, then they will be directed to a page that says "Success!". 


#### Case 2
When the User tries to log in, the User needs to type their username and password.
Then, when the User clicks the button, if everything is correct, then the User will be able to see the message "Sign in Completel!" and a loading page. 
Otherwise, the User will see the message "It's wrong", and they need to retype the username and password. 
