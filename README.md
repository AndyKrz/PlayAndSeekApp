# PlayAndSeek Application Spring Boot version 

![Spring Boot version of the Play And Seek](https://github.com/AndyKrz/PlayAndSeek/blob/main/PlayAndSeekView.jpg)

PlayAndSeek - website which is a network for people interested in a different kind of sports. 
You can create a profile which allows you to connect to whole community. Invite friends and announce a game. You can chat with whomever you want and arrange a time together. 
Application is based in Java programming language. I used Spring Boot as a base of the project, adding proper security and configuration. For a database I set H2 framework, where I implemented SQL statements. For a layout on internet browser I used HTML templates with Bootstrap to extend fresh style of web page. 


## Stack of technologies

**Spring:** SpringBoot, MVC, Data, Security, H2

**Web:** AngularJS, Bootstrap, Bower, Gulp

**Tests:** JUnit, Mockito, AssertJ

## Functionality

- Sign-In / Sign-Up
- Send messages
- Add / remove friends
- Update contact information / Change password
- View person & friend lists
- View person's contact information
- View last messages
- Profile images
- Search
- Meeting arrangement 


## How to Build & Run application from Intellij

```
git clone https://github.com/AndyKrz/play-and-seek-spring.git
cd play-and-seek-spring
./mvnw clean install
```
Start Spring boot application from the main class: `eu.andykrzemien.playAndSeek.PlayAndSeekApplication;`

Open [http://localhost:8080](http://localhost:8080) in your browser

The links below to get an application ids and secrets:

- Google: [https://developers.google.com/+/web/signin/server-side-flow#step_1_create_a_client_id_and_client_secret](https://developers.google.com/+/web/signin/server-side-flow#step_1_create_a_client_id_and_client_secret)
- Facebook: [https://developers.facebook.com/docs/facebook-login/v2.2](https://developers.facebook.com/docs/facebook-login/v2.2)
