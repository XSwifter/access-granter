# access-granter
Build & Deploy
  - clone this repository
  - mvn install
  - java -jar target/access-granter-0.0.1-SNAPSHOT
About 
  - The application is developed with Java 1.8, Angular 1.4.9 and an embedded H2 database and its goal 
  is to help users in managing users, roles and permissions.
Functionalities implemented :
  - Add User
  - Add Role
  - Add Permission
  - View active and available roles for an user
  - View active and available permissions for a role
  - Assign Roles to an User
  - Assign Permissions to a Role
  - Unassign a Role from an User
  - Unassign a Permission from a Role
  - View active permissions for an user
Technical details :
  - The project structure is layer oriented rather than feature oriented. The database tables have corresponding entities in the domain package with repositories and services that have those repos injected. I have chosen this approach, so that in the future development, have the services be able to act as an API not only deliver data to REST requests.
  - My main challenges in the development of the application were the technology version compatibility, mainly because of using an older version of Angular. For example, for alerts i had to use an older version angular-ui-bootstrap. Another challenge was to keep the project as simpler and cleaner as possible. For that i have chosen not to use a classic front-end package manager like npm, but to use webjars for front-end dependencies and wro4j for unifying the css and jss files(resources). I have chosen to use Angular(1.4.9) because i am used in working with this version and i like that i can structure the resources part in a more logical way that represents the business logic and application flow and this can be observed from the folder structure.
  - The embedded database will not drop-create the tables on application start, will just validate the DDL.
  - I have chosen to use Spring Boot because it is very easy to deploy and has an embedded Tomcat(8). 
