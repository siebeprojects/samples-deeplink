# samples-deeplink

Sample application show-casing how to launch a ChromeCustomTab and deep link back to the mobile app.

Two automated UI classes have been added to show-case the problem between the deprecated
ActivityTestRule and the new ActivityScenarioRule.

## Prerequisites

The deep link redirect flow requires HTML files hosted on a web server. These files are **not included** in this repository. Without them, opening a URL in the Chrome Custom Tab and redirecting back to the app will not work out of the box.

To make the redirect work, host an HTML page on your own server that triggers the deep link scheme registered in the app (`${applicationId}.mobileredirect`). Point the app's URL references to that server before running.

## Running the tests

The automated Espresso tests depend on the same hosted HTML files. Ensure your test server is reachable from the device or emulator before running the instrumented test suite.
