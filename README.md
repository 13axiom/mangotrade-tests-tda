<a href="https://mangotrade.com"><img src="images/logo/MangoTrade.svg" width="297.999" height="50.939"  alt="MANGOTRADE"/></a>

# Automation project for [MangoTrade.com](mangotrade.com)
## :bulb: Content:

- [Implemented automated checks](##Implemented-automated-checks)
- [Implemented manual checks](##Implemented-manual-checks)
- [Scheduled to automate checks](##Scheduled-to-automate-checks)
- [Technology stack](##Technology-stack)
- [Tests launch from Terminal](##Tests-launch-from-Terminal)
- [Tests launch from Jenkins](#Tests-launch-from-Jenkins#)
- [Tests results report in Allure Report](#Tests-results-report-in-Allure-Report)
- [Allure TestOps integration](#Allure-TestOps-integration)
- [Jira integration](#Jira-integration)
- [Telegram notifications using a bot](#Telegram-notifications-using-a-bot)
- [Example of test execution in Selenoid](#Example-of-test-execution-in-    Selenoid)
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

Current project is developing and it contains autotests written by <code>Java</code> with using code>Selenide</code> for UI-tests.
В данном проекте автотесты написаны на <code>Java</code> с использованием <code>Selenide</code> для UI-тестов.
>
> <code>Selenoid</code> executes browsers launch in containers <code>Docker</code>.
> <code>Selenoid</code> выполняет запуск браузеров в контейнерах <code>Docker</code>.
>
> <code>Allure Report</code> и <code>Allure TestOps</code> generate reports and graphs about tests launh,
> also them enable possibility to store and to track manual tests, which will be automated in the future.
> <code>Allure Report</code> и <code>Allure TestOps</code> формируют отчеты и графики о запуске тестов, а также
> возможность хранения и отслежтвания ручных тестов, которые в дальнейшем также могут быть автоматизирвоаны.
>
> For automated project builds is used <code>Gradle</code>.
> Для автоматизированной сборки проекта используется <code>Gradle</code>.
>
> As unit test library  is used <code>JUnit 5</code>.
> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>.
>
>  <code>Jenkins</code> executes launch of tests.
> <code>Jenkins</code> выполняет запуск тестов.
> After ending of a test run, notifications are sent by <code>Telegram</code> bot.
> После завершения прогона отправляются уведомления с помощью бота в <code>Telegram</code>.


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

> <code>REMOTE_DRIVER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.
> <code>REMOTE_DRIVER_URL</code> – remote server address, where tests will be launched.
> 
> REMOTE_DRIVER_USER, REMOTE_DRIVER_PASS - credits for remote server.
>
> <code>BROWSER</code> – browser, where test wil be executed (_default value: <code>chrome</code>_).
> <code>BROWSER</code> – браузер, в котором будут выполняться тесты (_по умолчанию - <code>chrome</code>_).
>
> <code>BROWSER_VERSION</code> – browser version, where test will be executed (_default value: <code>91.0</code>_).
> <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты (_по умолчанию - <code>91.0</code>_).
>
> <code>BROWSER_SIZE</code> – window size of browser, where test wil be executed (_default value: <code>1920x1080</code>_).
> <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты (_по умолчанию - <code>1920x1080</code>_).
> 
> <code>THREADS</code> - this setting gives possibility to launch specified number of tests in parallel.
> 
> <code>BROWSER_MOBILE</code> - mobile browser, where test will be executed (_default value: null)
> NOTE: this setting isn't used in current project, because mobile testing is the topic of future lessons

___
## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Tests launch from [Jenkins](https://jenkins.autotests.cloud/job/c11-lifetesting-mangotrade-tests-tda/)
*Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.*
*For launch remote tests it's necessary to click the option <code><strong>*Собрать с параметрами*</strong></code>, then to fill build settings and click the button <code><strong>*Собрать*</strong></code>.*
<p align="center">
  <img src="images/screens/Jenkins.png" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок <img width="2%" title="Allure Report" src="images/logo/Allure.svg"><code><strong>*Allure
Report*</strong></code>, кликнув по которому, откроется страница с сформированным html-отчетом.*
*After tests execution, in the panel <code><strong>*История сборок*</strong></code> in the row with build number will be appeared
icons <img width="2%" title="Allure Report" src="images/logo/Allure_Report.svg"><code><strong>*Allure Report*</strong></code>
and <img width="2%" title="Allure TestOps" src="images/logo/testops.png"><code><strong>*Allure TestOps*</strong></code>.
Icon <img width="2%" title="Allure Report" src="images/logo/Allure_Report.svg"><code><strong>*Allure Report*</strong></code> opens 
html-report in Allure Report.
Icon <img width="2%" title="Allure TestOps" src="images/logo/testops.png"><code><strong>*Allure TestOps*</strong></code> opens
html-report in Allure TestOps.*

<p align="center">
  <img src="images/screens/Jenkins2.png" alt="job" width="1000">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Tests results report in [Allure Report](https://jenkins.autotests.cloud/job/c11-lifetesting-mangotrade-tests-tda/50/allure/)

### :pushpin: Common information

*Allure report main page contains next informations blocks:* 
*Главная страница Allure-отчета содержит следующие информационные блоки:*
> - [x] <code><strong>*ALLURE REPORT*</strong></code> -  date and time of tests launch, total number executed cases and the diagram with indicating of percentage and number successful, failed and broken tests
>- [x] <code><strong>*TREND*</strong></code> - displays trend of passing tests from one build to other
>- [x] <code><strong>*SUITES*</strong></code> - displays the distribution of tests results by tests suites
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - displays test environment where tests were launched
>- [x] <code><strong>*CATEGORIES*</strong></code> - displays the distribution of failed tests by types of defects
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - displays the distribution of tests by functionality, which they checks
>- [x] <code><strong>*EXECUTORS*</strong></code> - displays the executor of the current build (link to Jenkins build)
> 
>- [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество прогнанных кейсов, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

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

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.
> After the test run is completed, created <code>Telegram</code>-bot automatically handles and sends a message with a test run report.   

<p align="center">
<img title="Telegram Notifications" src="images/screens/tgnotification.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Example of test execution in Selenoid

> A video is attached to each test in the report.

![video](images/video/testexecmango.mp4)