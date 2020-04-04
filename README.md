In order to run this project you'll need to:
 * Import this project into your choice of IDE as a Maven project
 * Run 'maven clean install' to download all dependencies and build the project
 * Run the process by running the main class: TaskApplication
 
Notes:
  * I've chosen to use H2 database - it's an in-memory relational DB that mainly used for testing purposes but I thought it would fit 
    nicely here as it wouldn't require you to configure a DB connection on your own - it loads automatically when the process loads up.
    You can access the H2 console by going to: http://localhost:8080/h2-console.
    Use:
    * JDBC URL: jdbc:h2:mem:testdb
    * user: sa
    * password: leave empty
  * The static page that allows to add a new record is located at: http://localhost:8080
  * I've chosen to implement the "Authenticated" part of the program by using an API-KEY mechanisem. I've created an API Keys table
    that is initialized with an api key = '1111'. When a request is made to the api, there's a filter that checks for the api key and
    validates the provided api key with the ones held in the DB ('1111' currently).
