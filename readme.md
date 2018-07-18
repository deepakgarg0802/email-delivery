# Email Sending Api

## Problem statement:

This problem requires you to implement a betaout email system. You have to implement the following api's:

1. Implement an api for sending email to users. (input user-email-id and email-content through api)
2. Implement an api for analysing previous email stats. (based on user-email-id)


## Important Notes:

- Email stats means user name, user email id, email sent date, email content and other important informations for analysis.
- Users have multiple emails on same email id. So in second api, display all emails information of user.
- First api is bulk api. (input may be more than one user)
- Use POST type for first api and GET type for second api.
- Use any programming language and database.
- README.md which explains installation and execution of code. Any further improvements
- Bonus points for clean, well documented and well structured code.
- Bonus points for design document

## Installation

- Install Spring Tool Suite, Maven and Java8
- Clone the project and import it as Maven project in Spring Tool Suite
- run `mvn clean install` inside project terminal

## Running App
- run project as Spring Boot Application
- open `http://localhost:8080/swagger-ui.html` in browser
- Enter Parameters in any Api
- Click on Try it Out

## Screenshots

- [Hello Api] (./ScreenShots/hello.png)
- [Post Mail Api] (./ScreenShots/post_mail.png)
- [Get Count of Mail] (./ScreenShots/getCount_mail.png)