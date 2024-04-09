# Craigslisttester

## Getting started

#### Requirements
  - Maven
  - Java jdk
  - Selenium
  - Chrome web driver

---
#### Running the tests
- Copy the `config.properties_example` in `src/test/resources/` & rename to `config.properties`
- Set chrome driver path
- Open a terminal and enter the following
    - `cd craigslisttester`
    - `mvn test`

#### Common issues
  - `mvn command is not recognized as an internal or external command`
    - Maven is missing from your system path [Maven/Java Path setup](https://www.youtube.com/watch?v=RfCWg5ay5B0https://www.youtube.com/watch?v=RfCWg5ay5B0)
  - The video above also goes through setting up java/jdk with it's path settings too