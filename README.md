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
5. About Section [AboutSection.java](craigslisttester/src/test/java/fgcuvladtyler/AboutSection.java)
   - TestAboutSection: Verify that the about section is accessible.
   - TestTermofUse: Verify that the terms of use page is accessible and loads correctly.
   - TestFrequentlyAskedQuestions: Verify that the FAQ page is accessible.
   - TestPrivacyPolicy: Verify that the privacy policy page is accessible.
   - TestHelp: Verify that the help page is accessible.
6. Event Calendar [EventCalendar.java](craigslisttester/src/test/java/fgcuvladtyler/EventCalendar.java)
   - TestEventCalendarLink: Verify that the event calendar link is accessible.
   - EventCalendarFavoriteButtonTest: Verify that the favorite button works correctly.
   - TestEventCalendarSearch: Verify that the search bar filters events correctly.
   - TestEventsCheckBox: Verify that the events checkbox filters events correctly.
7. Homepage [Homepage.java](craigslisttester/src/test/java/fgcuvladtyler/Homepage.java)
   - VerifyHomePageTitle: Check that the homepage title is correct.
   - VerifyFooterLinks: Check that all footer links are working.
   - TestLanguageLinksText: Verify that the language links are working.
   - TestLogo: Verify that the logo is displayed correctly.
8. World Wide sites [WorldWideSites.java](craigslisttester/src/test/java/fgcuvladtyler/WorldWideSites.java)
   - TestAboutCraigslistTitle: Check that the about craigslist page title is correct.
   - TestAboutCraigslistContent: Check that the about craigslist page content is correct.
   - TestAboutCraigslistFooter: Check that the about craigslist page footer is correct.
   - MmapTest: Check that the map is displayed correctly.

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