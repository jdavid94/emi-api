# EMI Calculator System

## Description
This application is an EMI (Equated Monthly Installment) calculator system developed with Spring Boot. It allows users to calculate EMI based on loan details like loan amount, interest rate, and loan term. This project is structured for a backend service and is ready to integrate with a front-end application for user input.

## Technologies Used
- Java 17
- Spring Boot
- Spring MVC
- Spring Validation
- Spring Web
- Lombok

## Prerequisites
- Java 17 or later
- Maven

## Project Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/jdavid94/emi-api.git
    ```
2. Navigate to the project directory:
    ```bash
    cd emi-api
    ```
## Running the Application
1. Start the application:
    ```bash
    mvn spring-boot:run
    ```
2. The backend server will start on `http://localhost:8080`.

## API Documentation
The API includes an endpoint for calculating EMI, with input validation and error handling.

### Calculate EMI Endpoint
- **URL**: `http://localhost:8080/api/calculate-emi`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
      "loanValue": 1000,
      "yearlyInterestRate": 5,
      "loanTerm": 12
    }
    ```
- **Response**:
    ```json
    {
      "emiAmount": 85.61
    }
    ```
- **Error Handling**: Returns a descriptive error message if validation fails.

## Design Decisions
- **Spring Boot**: Chosen for its efficient setup and rapid development capabilities.
- **Spring MVC**: Used to create RESTful APIs for EMI calculations.
- **Spring Validation**: Applied to ensure input values meet business rules.
- **Lombok**: Used to reduce boilerplate code, improving readability and maintainability.
- **JUnit**: Used to ensure code quality through unit tests.

## Project Structure

```plaintext
emi-calculator-backend
├── src
│   └── main
│       ├── java/com/example/emicalculator
│       │   ├── EmiCalculatorApplication.java        # Main application class
│       │   ├── config
│       │   │   └── WebConfig.java                   # CORS configuration
│       │   ├── controller
│       │   │   └── LoanController.java              # REST API controller
│       │   ├── service
│       │   │   └── LoanService.java                 # Business logic for EMI calculation
│       │   ├── model
│       │   │   └── LoanRequest.java                 # DTO for EMI request data
│       │   └── utils
│       │       └── CalculationUtils.java            # Utility for rounding EMI to two decimals
│       └── resources
│           └── application.properties               # Configuration file
└── pom.xml                                          # Maven configuration
