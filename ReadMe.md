#About / Synopsis

* ApiAutomationDesign is a project which has covered the test scenarios for testing different type of request for the api "http://jsonplaceholder.typicode.com/posts/"
* Project status: working


# Installation

- download the project zipped folder and place it in your workspace , all the dependencies and exe files are already placed in pom.xml and under resources folder

# Running the code

-- import the project in the workspace and run the testNG.xml file manually 

OR

-- Open cmd and go to the project location
-- type "mvn test" to run the code
-- only those testng.xml's will be exectued which have a entry in pom.xml under <testsuitexml> tag.
-- TESTNG.XML can also be directly run from cmd by typing "mvn clean test -Dtestsuitexml=testng.xml"

--  Code can also be run from eclipse by right clicking on testng.xml and run as testNG suite.

# Features

- ApiAutomationDesign  project contains different test cases to test the api "http://jsonplaceholder.typicode.com/posts/" and to ensure that the api  is  up and running fine.


-Uses extent report for making consolidated reports for the test cases

-Performs archiving logic on every run and saves the previous results under "Archive test results" folder

-- testData.properties contains the test data required by test cases and config.properties contains basic configuration related information required by the test cases

-Constants.java contains constants which are used across the whole application

# Requirements


- A stable internet connection
- Maven should be up on the system
-Postman for verifying the reponse of api's manually


# Build

    mvn clean install



# automation
