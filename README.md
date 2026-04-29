# RestAssured — API Test Automation (Java)

A comprehensive REST API test automation built with **REST Assured** and **Java**, covering a wide range of API testing concepts — from basic HTTP requests to authentication, serialization/deserialization, schema validation, and response parsing.

---

## 📁 Project Structure

```
RestAssured/
├── src/
│   ├── main/resources/
│   │   ├── jsonschema.json              # JSON schema file for schema validation tests
│   │   └── body.json                    # Sample request body JSON file
│   └── test/java/
│       ├── Authentications/
│       │   ├── BasicAuthentication.java      # Basic auth with REST Assured
│       │   ├── DigestAuthentication.java     # Digest auth handling
│       │   ├── PreemptiveAuthentication.java # Preemptive basic auth
│       │   └── Sample.java                   # Sample auth demo
│       ├── diffWaysToCreatePostRequestB.../
│       │   ├── Pojo_PostRequest.java         # POST request using POJO class
│       │   ├── UsingExternalJsonFile.java    # POST with external JSON file as body
│       │   ├── UsingHashMap.java             # POST with HashMap as request body
│       │   ├── UsingOrgJsonLibrary.java      # POST using org.json library
│       │   └── Using_POJO.java               # POST using POJO serialization
│       ├── pack1/
│       │   └── HTTP_Requests.java            # Core HTTP methods — GET, POST, PUT, DELETE, PATCH
│       ├── pack2/
│       │   ├── Cookies.java                  # Reading and validating response cookies
│       │   ├── Headers.java                  # Request/response header handling
│       │   ├── Logging.java                  # Request and response logging strategies
│       │   └── PathAndQueryParameters.java   # Path params and query params usage
│       ├── pack3/
│       │   ├── ParsingJsonResponseData.java  # Extracting values from JSON responses
│       │   └── ParsingXmlResponseData.java   # Extracting values from XML responses
│       ├── pack4/
│       │   ├── Deserialization.java          # Deserializing JSON response into POJO
│       │   ├── FakerLibrary.java             # Generating dynamic test data with Faker
│       │   ├── Serialization.java            # Serializing POJO to JSON request body
│       │   └── student.java                  # POJO model class for student entity
│       └── schemaValidation/
│           └── JsonSchemaValidation.java     # Validating response against JSON schema
├── .gitignore
├── body.json                                 # Root-level request body sample
└── pom.xml                                   # Maven build and dependency configuration
```

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven
- IDE: IntelliJ IDEA or Eclipse
- Internet access (tests run against public APIs like ReqRes, JSONPlaceholder, etc.)

### Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd RestAssured
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run all tests**
   ```bash
   mvn test
   ```

4. **Run a specific test class**
   ```bash
   mvn -Dtest=HTTP_Requests test
   ```

---

### Key Dependencies (`pom.xml`)

```xml
<dependencies>
    <!-- REST Assured -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.x.x</version>
        <scope>test</scope>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.x.x</version>
        <scope>test</scope>
    </dependency>

    <!-- Jackson (Serialization / Deserialization) -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.x.x</version>
    </dependency>

    <!-- JSON Schema Validator -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>json-schema-validator</artifactId>
        <version>5.x.x</version>
    </dependency>

    <!-- Java Faker -->
    <dependency>
        <groupId>com.github.javafaker</groupId>
        <artifactId>javafaker</artifactId>
        <version>1.0.2</version>
    </dependency>

    <!-- Org JSON -->
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20231013</version>
    </dependency>
</dependencies>
```

---

## 📦 Module Overview

### `pack1` — HTTP Requests
Covers all standard HTTP methods using REST Assured's fluent `given().when().then()` syntax.
```java
given().when().get("/users/2").then().statusCode(200);
```

### `pack2` — Headers, Cookies, Logging & Parameters
- **Headers** — setting custom request headers, asserting response headers
- **Cookies** — reading and validating cookies from responses
- **Logging** — `log().all()`, `log().ifError()` for request/response logging
- **PathAndQueryParameters** — using `pathParam()` and `queryParam()`

### `pack3` — Response Parsing
- **JSON Parsing** — extracting values using `jsonPath()` and GPath expressions
- **XML Parsing** — extracting values from XML responses using `xmlPath()`

### `pack4` — Serialization & Deserialization
- **Serialization** — converting a Java POJO to a JSON request body automatically
- **Deserialization** — mapping a JSON response body back into a POJO
- **FakerLibrary** — generating realistic dynamic test data (names, emails, addresses)
- **student.java** — POJO model used across serialization/deserialization tests

### `Authentications` — Auth Strategies
- **BasicAuthentication** — `auth().basic(username, password)`
- **DigestAuthentication** — `auth().digest(username, password)`
- **PreemptiveAuthentication** — `auth().preemptive().basic(username, password)`

### `diffWaysToCreatePostRequestBody` — POST Request Body Styles
Five different approaches to building a POST request body:
| Approach | Class |
|---|---|
| POJO class | `Pojo_PostRequest.java` / `Using_POJO.java` |
| HashMap | `UsingHashMap.java` |
| External JSON file | `UsingExternalJsonFile.java` |
| org.json library | `UsingOrgJsonLibrary.java` |

### `schemaValidation` — JSON Schema Validation
Validates the structure and data types of an API response against a predefined JSON schema stored in `main/resources/jsonschema.json`.
```java
get("/users").then().assertThat().body(matchesJsonSchemaInClasspath("jsonschema.json"));
```

---

## 🛠️ Technologies Used

| Tool | Purpose |
|---|---|
| REST Assured | API test automation |
| Java | Primary language |
| TestNG | Test execution & assertions |
| Jackson | JSON serialization / deserialization |
| JSON Schema Validator | Response structure validation |
| Java Faker | Dynamic test data generation |
| org.json | Alternate JSON body building |
| Maven | Build and dependency management |

---

## 📌 Best Practices Followed

- BDD-style `given().when().then()` syntax throughout
- Multiple approaches to POST body creation for flexibility
- POJO-based serialization/deserialization for type-safe request/response handling
- JSON Schema validation to catch API contract breakages
- Dynamic test data generation using Faker to avoid hardcoded values
- Logging enabled for easier debugging of failures

---

## 📄 License

This project is intended for educational and practice purposes.
