**_APIOrder_** => Spring Boot application for Tokopedia API testing assignment

For building and running the application you need:

    JDK 1.8
    Maven 3x


**_Tools and frameworks employed:_**

`Maven`
`Cucumber`
`TestNG`
 `RestAssured`

**_Libraries Used:_**
`Lombok,
SpringBoot`

Below are the components of API order application :

_•	ApiOrderController (Controller)
•	Order (Model)_

_OrderRequest_ and _OrderResponse_ are POJO templates of request and response json respectively.

**_Constants_** : It is a Java class file to hold the constant values.

APIOrder application should be started to run our tests

_**Running the application locally :**_

`mvn spring-boot:run`

**_APIOrder tests :_**

There are two types of tests available to validate API

•	**_APIOrderControllerTest_** : In this class, testNG has been leveraged to execute the tests. There are three methods and each one has its own testing purpose.They are written to validate _order status,last_updated_timestamp and statusode._(All these methods have @Test annotation of TestNG package)

There is a method : reqSetup() which has @BeforeClass annotation which is used to setup the request specification

Command to execute TestNG tests : `mvn test`

•	_**Cucumber Tests with TestNG**_ : Test scenarios in Gherkin format are written in feature files which is used to validate positive and negative scenarios

Two different ways to execute Cucumber Tests :

	TestRunner : Configure the test runner and execute it via IDE (IntelliJ / eclipse) based on the tags specified in the testrunner file
   Run mvn command to execute the tests along with cucumber options

`mvn test -Dcucumber.filter.tags="@ORDER and @statusCode"` (to run the scenarios with tests the status code)
`mvn test -Dcucumber.filter.tags="@ORDER"` (to run all the scenarios in the feature file).

_HTML reports_ will be generated in the target folder once the code gets executed.



**_Improvement areas in the framework :_**

1.Data handling can be made better by externalizing the data through json/xl.

2.Karate framework could have been experimented.Due to time constraints , I am settled with RestAssured.

3.Reporting can be made better by leveraging eith extent or allure or reportportal.io.

_P.S. : Generated sample Spring boot application from https://start.spring.io/ ._ 

_This assignment has helped me to start learn Spring boot and experiment with it._


Sample reports :

<img width="1428" alt="image" src="https://user-images.githubusercontent.com/15065249/183743438-9c2394c4-ffe5-4213-b7ad-6b008ae2ecc8.png">




Screenshot 2022-08-10 at 12.50.24 AM<img width="1439" alt="image" src="https://user-images.githubusercontent.com/15065249/183743682-952474ef-8d5a-4600-868a-f3cb86dae5b1.png">



