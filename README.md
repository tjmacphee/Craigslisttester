# Craigslisttester

## Getting started

#### Requirements
  - Maven
  - Java jdk
  - Selenium
  - Chrome web driver

---
### Tests covered:
1. User Registration and Authentication
   - TestSignUpPage: Test if the signup page loads correctly.
   - TestSignUpFunctionality: Ensure that users can sign up with valid details.
   - TestLoginPage: Verify that the login page is accessible and fields are interactable.
   - TestLoginFunctionality: Check login functionality with correct and incorrect credentials.
2. Listings & Search Functionality
   - TestSearchBar: Verify that the search bar returns results based on keyword input.
   - TestCategoryFilter: Test the functionality of category-based filtering.
   - TestLocationFilter: Ensure location-based filtering works as expected.
   - TestListingDetails: Verify that clicking on a listing opens the details page with correct information.
3. Posting Listings
   - TestPostListingPage: Check if the post listing page loads correctly.
   - TestPostListingFunctionality: Ensure users can create a listing with valid details.
   - TestEditListing: Verify that users can edit their listings after posting.
   - TestDeleteListing: Ensure users can delete their listings.
4. User Profile and Settings
   - TestProfilePage: Verify that the user profile page loads correctly.
   - TestProfileUpdate: Test updating user profile information.
   - TestChangePassword: Ensure users can change their password.
   - TestEmailNotificationsSettings: Verify users can update their email notification preferences.
5. Messaging and Communication
   - TestMessageListPage: Ensure the user’s message list page loads correctly.
   - TestSendMessage: Verify users can send messages to listing owners.
   - TestReceiveMessage: Ensure users can receive messages.
   - TestDeleteMessage: Verify users can delete messages from their inbox.
6. Image Uploads and Management
   - TestImageUpload: Verify users can upload images with their listings.
   - TestImageDeletion: Ensure users can delete images from their listings.
   - TestImageDisplay: Verify that images are correctly displayed in listings.
   - TestImageLimit: Ensure there's a limit to the number of images per listing.
7. Navigation and UI Elements
   - TestHeaderLinks: Verify that header links (home, my account, post a listing, etc.) work.
   - TestFooterLinks: Check that footer links (about, terms of use, privacy policy, etc.) are accessible.
   - TestMobileResponsive: Verify the website is responsive on mobile devices.
   - TestBreadcrumbNavigation: Test the functionality of breadcrumb navigation for ease of use.
8. Accessibility compliance
   - TestScreenReaderCompatibility: Verify the site's compatibility with screen readers.
   - TestKeyboardNavigation: Ensure that the website can be navigated using keyboard commands alone.
   - TestContrastRatio: Check that text and background color contrasts meet WCAG.
   - TestAltTextForImages: Ensure all images have descriptive alt texts for users who rely on screen readers.

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