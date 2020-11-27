#About 

Astronomy Picture of the Day (APOD) is one of the most popular websites at NASA and in fact  is one of the most popular websites across all federal 
agencies. This endpoint https://api.nasa.gov/planetary/apod structures the APOD imagery and associated metadata so that it can be repurposed for other
applications.

The HTTP request GET https://api.nasa.gov/planetary/apod takes 4 input parameters. The first is a mandatory alphanumeric 'API Key' for authentication
and expanded usage, next is 'Date', which is by default today's date, is the date of the APOD image to retrieve the next parameter 'hd' takes boolean value
which by default is 'False' and when set to True- returns a HD image. Last is the 'concept_tags' parameter when set to True, then keywords derived from the image
explanations are returned. These keywords could generally help with discoverability of relevant imagery.



# Installation

- download the project zipped folder and place it in your workspace , all the dependencies and exe files are already placed in pom.xml and under resources folder

# Running the code

-- import the project in the workspace and run the testNG.xml file manually 

OR

-- Open cmd and go to the project location
-- type "mvn test" to run the code
--  Code can also be run from eclipse by right clicking on testng.xml and run as testNG suite.


# Requirements


- A stable internet connection
- Maven should be up on the system
-Postman for verifying the reponse of api's manually


# Build

    mvn clean install
    
# TestPlan 

Following  stages of testing must be covered in order to make this API acceptable for public usage.

1. Functional Testing
2. Performance Testing
3. Automation Testing

Functional Testing  : Verifying the functionality of the API when provided API key, Date, hd and concept_tag  parameters.
Tools Used - Postman.
Aim - Functionally validate the API

Test the API with the following functional parameters using test cases as listed below: 

Validate if API is returning correct response code(200) with valid api key.
Validate if API is returning correct response code with valid Date.
Validate if API is returning correct response code when hd is set to true.
Validate if API is returning correct response code when hd is set to false.
Validate if API is returning correct response code when concept_tag is set to true.
Validate if API is returning correct response code when concept_tag is set to false.
Validate  if API is returning error response code when entered  Out of range (before June 16, 1995 )
Validate  if API is returning error response code when entered   future dates.
Validate  if API is returning error response code with incorrect format.
Validate if API is returning correct response codes when checked with boundary conditions  of  Date:
Verify when the date is set to   Jun 16, 1995
 Verify when the date is set to Jun 15, 1995
Verify when the date is set to today's date 
Verify when the date is set to tomorrow's date.


Performance Testing : Verify the performance of the API with parameters - Response time, Throughput and User Load. Create performance scripts based on above params and try to validate the actual results.
Tools Used - Jmeter
Aim - Non functional testing 
Based on above params we will create performance script and try to validate the actual results


# automation

API : https://api.nasa.gov/planetary/apod   

Tools Used - Java, Rest Assured, TestNG,Maven
Aim - to automate the functional test cases 

