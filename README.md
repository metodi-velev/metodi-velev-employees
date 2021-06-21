# metodi-velev-employees
Find the pair of employees longest working together on same projects. Display the team longevity of each colleagues pair including the longest working one.
The information about the longest working pair concerns all common projects and the sum of working days on all common projects.
<br>
The test file is named "employees-projects.txt" and is located under "src/main/resources" and is analysed by the spring boot application at its start.
<br><br>
EmpID, ProjectID, DateFrom, DateTo
<br>
100, 10, 2000-01-01, 2001-01-01
<br>
200, 10, 2000-01-01, 2001-01-01
<br>
300, 11, 2000-01-01, 2001-01-02
<br>
400, 11, 2000-01-01, 2001-01-02
<br>
100, 12, 2001-01-01, 2002-01-01
<br>
200, 12, 2001-01-01, 2002-01-01
<br>
500, 12, 2001-01-01, 2002-01-01
<br>
500, 13, 2003-01-01, 2006-01-01
<br>
100, 13, 2003-01-01, 2006-01-01
<br>
500, 14, 2007-01-01, 2008-01-01
<br>
100, 14, 2007-01-01, 2008-01-01
<br>
100, 15, 2015-01-01, NULL
<br>
200, 15, 2015-01-03, NULL
<br><br>
- NULL value stands for the date today. Longest working pair in "employees-projects.txt" is the eployees pair with (empId1, empId2) = (100, 200). They have worked on projects with project id 15 for 2361 days, with project id 10 for 366 days and with project id 12 for 365 days with the overall time period of 2361 + 366 + 365 = 3092 days.
- The UI is built using Thymeleaf. From the UI the user can select a custom text file, which is then upooaded in the "src/main/resources" directory of the application. The working pairs are calculated after the upload and then displayed with their time longevity as the case is with "employees-projects.txt". 
- The application is packaged as a jar file and is started as every other jar-archived Spring Boot application can be started with right click on the project and selecting run as java application or for example from the command prompth with maven by running the command <i>mvn spring-boot:run</i> from the root directory of the application.
