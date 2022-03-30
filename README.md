<a href="https://mangotrade.com"><img src="images/logo/MangoTrade.svg" width="297.999" height="50.939"  alt="MANGOTRADE"/></a>

# Automation project for [MangoTrade.com](mangotrade.com)
## :bulb: Content:

- [Implemented automated checks](#white_check_mark-Implemented-automated-checks)
- [Implemented manual checks](#hand-Implemented-manual-checks)
- [Scheduled to automate checks](#soon-Scheduled-to-automate-checks)
- [Technology stack](#gear-Technology-stack)
- [Tests launch from Terminal](#Tests-launch-from-Terminal)
- [Tests launch from Jenkins](#-Tests-launch-from-Jenkins#)
- [Tests results report in Allure Report](#-Tests-results-report-in-Allure-Report)
- [Allure TestOps integration](#-Allure-TestOps-integration)
- [Jira integration](#-Jira-integration)
- [Telegram notifications using a bot](#-Telegram-notifications-using-a-bot)
- [Example of test execution in Selenoid](#-Example-of-test-execution-in-Selenoid)
___

## :white_check_mark: Implemented automated checks
- [x] Success login to account
- [x] Failed login with null data
- [x] Failed login without Email
- [x] Failed login without Password
- [x] Login form has form header 'Log In'
- [x] 'Log in' page should have warning about risks
- [x] Page console log should not have errors
- [x] Successful redirect to registration form

## :hand: Implemented manual checks
- [x] Success login to account by widget on main page

## :soon: Scheduled to automate checks
- [ ] api login checks
- [ ] logut checks
- [ ] switch language api checks

## :gear: Technology stack
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="images/logo/testops.png" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://telegram.org/?setln=en/"><img src="images/logo/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

Current project is developing and it contains autotests written by <code>Java</code> with using <code>Selenide</code> for UI-tests.
>
> <code>Selenoid</code> executes browsers launch in containers <code>Docker</code>.
>
> <code>Allure Report</code> and <code>Allure TestOps</code> generate reports and graphs about tests launch,
> also they enable possibility to store and to track manual tests, which will be automated in the future.
>
> <code>Gradle</code> is used for automated project builds.
>
> <code>JUnit 5</code> is used as unit test library.
>
> <code>Jenkins</code> executes launch of tests.
> After ending the test run, notifications are sent by <code>Telegram</code> bot.

##  Tests launch from Terminal

### :wrench: Local tests launch

```
gradle clean test
```

### :hammer_and_wrench:	 Remote tests launch

```
clean
test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://${REMOTE_DRIVER_USER}:${REMOTE_DRIVER_PASS}@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

### :clipboard:	 Build settings

> <code>REMOTE_DRIVER_URL</code> – remote server address, where tests will be launched.
> 
> <code>REMOTE_DRIVER_USER, REMOTE_DRIVER_PASS</code> - credits for remote server.
>
> <code>BROWSER</code> – browser, where tests will be executed (_default value: <code>chrome</code>_).
>
> <code>BROWSER_VERSION</code> – browser version, where tests will be executed (_default value: <code>91.0</code>_).
>
> <code>BROWSER_SIZE</code> – window size of browser, where tests wil be executed (_default value: <code>1920x1080</code>_).
> 
> <code>THREADS</code> - this setting gives possibility to launch specified number of tests in parallel.
> 
> <code>BROWSER_MOBILE</code> - mobile browser, where tests will be executed (_default value: null)
> NOTE: this setting isn't used in current project, because mobile testing is the topic of future lessons

___
## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Tests launch from [Jenkins](https://jenkins.autotests.cloud/job/c11-lifetesting-mangotrade-tests-tda/)
*For launch remote tests it's necessary to click the option <code><strong>*Собрать с параметрами*</strong></code>, then to fill build settings and to click the button <code><strong>*Собрать*</strong></code>.*
<p align="center">
  <img src="images/screens/Jenkins.png" alt="job" width="800">
</p>

*After tests execution, in the panel <code><strong>*История сборок*</strong></code> in the row with build number
icons <img width="2%" title="Allure Report" src="images/logo/Allure_Report.svg"><code><strong>*Allure Report*</strong></code>
and <img width="2%" title="Allure TestOps" src="images/logo/testops.png"><code><strong>*Allure TestOps*</strong></code> will appear.*

*Icon <img width="2%" title="Allure Report" src="images/logo/Allure_Report.svg"><code><strong>*Allure Report*</strong></code> opens 
html-report in Allure Report.*

*Icon <img width="2%" title="Allure TestOps" src="images/logo/testops.png"><code><strong>*Allure TestOps*</strong></code> opens
html-report in Allure TestOps.*

<p align="center">
  <img src="images/screens/Jenkins2.png" alt="job" width="1000">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Tests results report in [Allure Report](https://jenkins.autotests.cloud/job/c11-lifetesting-mangotrade-tests-tda/50/allure/)

### :pushpin: Common information

*Allure report main page contains next information blocks:* 
> - [x] <code><strong>*ALLURE REPORT*</strong></code> -  date and time of tests launch, total number of executed cases and the diagram with indication of percentage and number of successful, failed and broken tests
>- [x] <code><strong>*TREND*</strong></code> - displays trend of passing tests from one build to another
>- [x] <code><strong>*SUITES*</strong></code> - displays the distribution of tests results by tests suites
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - displays test environment where tests were launched
>- [x] <code><strong>*CATEGORIES*</strong></code> - displays the distribution of failed tests by types of defects
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - displays the distribution of tests by functionality, which they check
>- [x] <code><strong>*EXECUTORS*</strong></code> - displays the executor of the current build (link to Jenkins build)

<p align="center">
  <img src="images/screens/AllureReport.png" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="images/logo/testops.png"> [Allure TestOps](https://allure.autotests.cloud/launch/11665) integration

### :pushpin: Overview dashboard

<p align="center">
  <img src="images/screens/TestOpsOverview.png" alt="dashboards" width="900">
</p>

### :pushpin: Test cases

<p align="center">
  <img src="images/screens/TestOpsTC.png" alt="test cases" width="900">
</p>

## <img width="4%" title="Jira" src="images/logo/Jira.svg"> [Jira](https://jira.autotests.cloud/browse/AUTO-810) integration

<p align="center">
  <img src="images/screens/jira.png" alt="jira" width="1000">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications using a bot

 > After the test run is completed, created <code>Telegram</code>-bot automatically handles and sends a message with a test run report.   

<p align="center">
<img title="Telegram Notifications" src="images/screens/tgnotification.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Example of test execution in Selenoid

> A video is attached to each test in the report.



https://user-images.githubusercontent.com/84909251/160829280-81dffde8-a9ad-4b75-9e2a-2a19c6019a74.mp4

