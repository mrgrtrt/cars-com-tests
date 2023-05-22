## Test task
cars.com

### Used tools
- Playwright
- TestNG
- Maven

### Run tests
mvn clean test

### CI + Report
Github Actions used for CI - on each push main branch test run is triggered.

Allure report is used for reporting.
mvn allure:serve
