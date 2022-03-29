package com.mangotrade.tests;

import com.mangotrade.config.Project;
import com.mangotrade.helpers.AllureAttachments;
import com.mangotrade.helpers.DriverSettings;
import com.mangotrade.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.qameta.allure.Allure.step;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
       /*//String remoteBrowserUser = System.getProperty("remote_browser_user");
       // String remoteBrowserPassword = System.getProperty("remote_browser_password");

        step("Настраиваем тестируемую страницу", () -> {
            Configuration.baseUrl = "https://trade.mangotrade.com";
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.browserSize = System.getProperty("browser_size", "3840x2160");

            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        });*/
    }



    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
