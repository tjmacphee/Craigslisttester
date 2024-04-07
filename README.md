# Runescapetester

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
    - `cd runescapetester`
    - `mvn test`

#### Common issues

- `mvn command is not recognized as an internal or external command`
    - Maven is missing from your system
      path [Maven/Java Path setup](https://www.youtube.com/watch?v=RfCWg5ay5B0https://www.youtube.com/watch?v=RfCWg5ay5B0)
- The video above also goes through setting up java/jdk with it's path settings too

#### Notes

1. Create a test suite for a software system

- a. Your project could be an application of Integration, System, End-to-end, Acceptance or
  regression testing
- b. Must include at least 8-unit tests (in separate classes)
- c. Must include a combined test code( integration) using any testing tool for all unit tests.
- d. Can be an improvisation of your past or current personal projects, senior project, and
  open-source repositories
