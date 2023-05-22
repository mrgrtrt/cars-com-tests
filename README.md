## Test task
cars.com

### Used tools
- Playwright
- TestNG
- Maven

### Run tests
mvn clean test

### CI + Report
DOES NOT WORK WITH PLAYWRIGHT Github Actions used for CI - on each push main branch test run is triggered.

Allure report is used for reporting.
mvn allure:serve

<img width="1440" alt="Screenshot 2023-05-22 at 15 31 27" src="https://github.com/mrgrtrt/cars-com-tests/assets/22737791/70f106be-4066-4f0a-8f82-3ed832b9df41">
