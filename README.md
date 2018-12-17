# Assignment2
**Youtube Link**

https://youtu.be/4QZipZ0nQuI

The first thing you see when starting the app is the splashscreen, which then brings you to the home screen.
Every screen can be accessed from the navigation menu in the topright of the screen.
Now we will go to the tables screen which will have the standings in the League of Ireland, This was made using a table layout within android studio.
Now we will go to the stats page which keeps track of the top goalscorers in the league. This screen is made using a list view in a relative layout.
Next is the donation screen which allows users to donate to a club of their choice. The payment method is creating using radio buttons, picking a team is created using a spinner, a number picker is used to pick a number between 0-1000, a progress bar up to €10,000 which tracks the money donated. A place to type in the amount you want to donate and finally a donate button to submit your donation.
First I will choose PayPal as the payment method, then Cork City as the team, Pick €100 from the number picker, then hit donate. The progress bar fills with red after hitting the donate button.
The information should be recorded and it will be checked by going to the report screen. As it can be seen the payment method, club and amount is recorded.
Go back to the donate screen and try out typing out a donation, do the same thing as before but change it up a little but instead of using the number picker, we will be using the text box with amount written on it. Type in an amount and hit donate, then go to report and we can see the payment is recoreded in the report screen.
I will show how registration works,on the registration screen the user is told to enter details into the text fields. Firebase will have no users registered to the app. So we will fill the fields and when done click register, we get brought to the home screen and a message saying "registration successfull". Then I will reload Firebase and notice the registered accoubt is there. The i will go to the database in firebase and notice that all the details have been saved.
After a successful registration the user will auto login so to check if the login works we will first logout then login.
We will enter the email and password we used in registration, then we successfully login showing that the app is gathering the data from the cloud.
We will then go to profile which will display all the data stored in the database, we will now edit some of the information. I will change Cork City to Dundalk and press save. As can be seen in the database it updates in real-time.
I will know change the password from 12345678 to 123456789 and press update. To check if it worked I will logout and login.
The login was successful and know show how Facebook login was integrated into the app. Click on the Facebook button which will bring me to a new screen where I enter my facebook login details.
The final feature of the app is the ability to reset password, go ot the login screen click on forgot password and then type in ypur email address that was used to register the account with. I will go to my email and see an email, click on it and reset my password and change it to 'helloworld'. Then I will login again with my new password and it was successfull.
These are all the features in my mobile app for Assignment 2.
