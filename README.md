<a href="https://mangotrade.com"><img src="images/logo/MangoTrade.svg" width="297.999" height="50.939"  alt="MANGOTRADE"/></a>

# Automation project for [MangoTrade.com](mangotrade.com)
## :bulb: Содержание:

- [Implemented automated checks](##Implemented-automated-checks)
- [Implemented manual checks](##Implemented-manual-checks)
- [Scheduled to automate checks](##Scheduled-to-automate-checks)
- [Technology stack](##Technology-stack)

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

## :white_check_mark: Implemented manual checks
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

# Project in Allure TestOps with manual & automated tests
___
# Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/%s">jenkins.autotests.cloud/job/%s</a>


# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)


Run tests with filled remote.properties:
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:
```bash
allure serve build/allure-results
```


###### For further development there are some example tests in src/test/java/cloud.autotests/tests/demowebshop
* remove @Disabled("...") annotation to run tests
```bash
gradle clean demowebshop
```

:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
