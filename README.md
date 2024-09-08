# ReqRes API Automation Project

## Overview

This project demonstrates how to automate user creation using the ReqRes API with RestAssured in Java. The automation script performs the following actions:

1. Creates a JSON object containing user data.
2. Sends a POST request to the ReqRes API to create a user.
3. Asserts that the response status code is `201` (Created), indicating successful user creation.
4. Validates that the response body contains the required data (ID, name, job).

## Prerequisites

- Java 8 or higher
- Maven
- RestAssured library
- JSON library (org.json)

## Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/reqres-api-automation.git
   cd reqres-api-automation

2. **Install Dependencies**

   Ensure you have Maven installed. Run the following command to install the required dependencies:
   mvn install

## Running the Automation
    mvn exec:java -Dexec.mainClass="com.example.PaySkyApiTest"

## Test Result Screenshot

![image](https://github.com/user-attachments/assets/0a97c77a-ab36-472f-8979-d5cdefa997f3)


## Code Explanation

  - OrangeHRMTest.java: Contains the main class with methods to send POST requests and validate responses.
  - createCandidateJson(): Creates a JSON object with user data.
  - addCandidate(): Sends the POST request and validates the response.
