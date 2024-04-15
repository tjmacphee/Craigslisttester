# Craigslisttester

## Getting started

#### Requirements
  - Maven
  - Java jdk
  - Selenium
  - Chrome web driver

---
### Tests covered:
1. User Registration and Authentication [Signup.java](craigslisttester/src/test/java/fgcuvladtyler/Signup.java)
   - TestSignUpPage: Test if the signup page loads correctly.
   - TestSignUpFunctionality: Ensure that users can sign up with valid details.
   - TestLoginFunctionality: Check login functionality with credentials.
   - TestForgotPasswordFunctionality: Check forgot password functionality.
2. Listings & Search Functionality [ListingsAndSearch.java](craigslisttester/src/test/java/fgcuvladtyler/ListingsAndSearch.java)
   - TestSearchBar: Verify that the search bar returns results based on keyword input.
   - TestCategoryFilter: Test the functionality of category-based filtering.
   - TestLocationFilter: Ensure location-based filtering works as expected.
   - TestListingDetails: Verify that clicking on a listing opens the details page with correct information.
3. Posting Listings [Posting.java](craigslisttester/src/test/java/fgcuvladtyler/Posting.java)
   - TestPostListingPage: Check if the post listing page loads correctly.
   - TestPostListingFunctionality: Ensure users can create a listing with valid details.
   - TestEditListing: Verify that users can edit their listings after posting.
   - TestDeleteListing: Ensure users can delete their listings.
4. User Profile and Settings [Profile.java](craigslisttester/src/test/java/fgcuvladtyler/Profile.java)
   - TestProfilePage: Verify that the user profile page loads correctly.
   - TestDraftsPage: Verify that the drafts page loads correctly.
   - TestSearchesPage: Verify that the searches page loads correctly.
   - TestSettingsPage: Verify that the settings page loads correctly.
5. Web Page Sites [WorldWideSites.java](craigslisttester/src/test/java/fgcuvladtyler/WorldWideSites.java)
   - TestAboutCraigslistTitle: Verify Title is correct.
   - TestAboutCraigslistContent: Verify Content is present on page.
   - TestAboutCraigslistFooter: Verify footer links are correct.
   - TestMapTest: Verify the map is present on load.
6. Homepage [Homepage.java](craigslisttester/src/test/java/fgcuvladtyler/Homepage.java)
   - TestVerifyHomePageTitle: Verify homepage title is correct.
   - TestVerifyFooterLinks: Verify footer links are correct.
   - TestLanguageLinksText: Verify support for multiple languages.
   - TestLogo: Verify logo is present.
7. Events & Calendar [EventsCalendar.java](craigslisttester/src/test/java/fgcuvladtyler/EventsCalendar.java)
   - TestEventCalendarLink: Test calendar events link works.
   - TestEventCalendarFavoriteButtonTest: Test favorites button works.
   - TestEventCalendarSearch: Test calendar/events search works.
   - TestEventsCheckBox: Test filter checkboxes work.
8. About Section [AboutSection.java](craigslisttester/src/test/java/fgcuvladtyler/AboutSection.java)
   - TestAboutSection: Verify the about page loads.
   - TestTOS: Verify TOS page loads.
   - TestFrequentlyAskedQuestions: Verify FAQ page loads
   - TestPrivacyPolicy: Verify Privacy Policy page loads.

---
#### Running the tests
- Copy the `config.properties_example` in `src/test/resources/` & rename to `config.properties`
- Set chrome driver path
- Open a terminal and enter the following
    - `cd craigslisttester`
    - `mvn test`

#### Viewing test reports
To view the report, head to [emailable-report.html](craigslisttester/target/surefire-reports/emailable-report.html), and open it inside your web browser
  - To do this, right-click the file & choose `'Open in File Explorer'/'Open in Finder'`, then open it in the browser.

In case of a test failure, view the [TestSuite.txt](craigslisttester/target/surefire-reports/TestSuite.txt) for a error log w/ stack trace

#### Common issues
  - `mvn command is not recognized as an internal or external command`
    - Maven is missing from your system path [Maven/Java Path setup](https://www.youtube.com/watch?v=RfCWg5ay5B0https://www.youtube.com/watch?v=RfCWg5ay5B0)
  - The video above also goes through setting up java/jdk with it's path settings too