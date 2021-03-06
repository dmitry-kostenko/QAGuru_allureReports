package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 65;

    @Test
    public void checkIssueByNumber() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $(".header-search-input").val(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText("#" + ISSUE_NUMBER)).shouldBe(Condition.visible);

    }
}
