Coverage: 91.1%
# QA Training Project 2: Hero Storage System

A simple storage system: creating, storing and retrieving "heroes" from a database with a simple front-end in the form of html and js. Made as the second project of three as a part of QA digital consultancy training.

## Project Overview

### Jira
I used a Jira based Kanban Board for the organisation and management of this project. 
Here is one example of a user story I created:
![Jira user story example](https://i.imgur.com/6hj1q2s.png)
As seen above, I use more general user stories but then link them as "blocked by" with the necessary tasks to be completed.
I also linked the user stories with any prerequisite tasks as needed. In the description section of each user story is the acceptance criteria.

I used the in-built story estimation point and prioritisation functionality of Jira for each user story. The priority tag "Highest" refers to "Must have" issues

I used the Jira-Github Integration app, commiting with comments to relevant user stories as seen in the previous screenshot.
### Git and Github
Throughout the project I utilized the branch function of Git to distinguish between different features and functionalities during the development cycle. 
These branches were linked largely to the epics that my user stories were split into. The reason for a less granular approach was largely due to the simplistic nature of the project.

Once development of the feature was completed I would use a pull request on Github to merge the feature into the "dev" branch. A disply of completed pull requests are seen [here](https://github.com/theJAtkinson/theJAtkinson_assessment2/pulls?q=is%3Apr+is%3Aclosed).

### SQL Data Design
Compared to the first project, the SQL database design is much simpler. In this case there is only one table and a handful of parameters or columns: the heroes name, a description of their powers, an integer power level and
a tragic backstory.

### UI Design
I chose a simple one-page design which utilizes various buttons to operate the CRUD functions. 

IMAGE OF DESIGN

## Running the Program

To run the program itself you can simply download java, more specifically JRE.

The download for Java can be found [here](https://www.java.com/download/ie_manual.jsp), with further installation instructions and system requirements included. With the Java installed one can run the theJAtkinson_assessment2-1.0.0.jar program from a terminal with the command: 
>java -jar theJAtkinson_assessment2-1.0.0.jar

Or if you are on windows you can run the theJAtkinson_assessment2-1.0.0.bat included in this repo.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipse](https://www.eclipse.org/) - IDE
* [Java](https://www.oracle.com/index.html) - Development and Runtime Environment
* [SQL](https://www.mysql.com/why-mysql/presentations/mysql-80-overview/) - Database and server
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework and Integration

## Authors

* **Jonah Atkinson**- *Main Project*