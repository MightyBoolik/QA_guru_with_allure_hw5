package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class IssueTestInGithub {
    public static final String ISSUE = "Issue";
    public static final String REPOSITARY = "MightyBoolik/QA_guru_with_allure_hw5";
    public final static int ISSUE_NUMBER = 1;
    @Disabled
    @Test
    public void testGithubIssue(){
        open("https://github.com/");
        $(byName("q")).val(REPOSITARY).pressEnter();
        $(By.linkText(REPOSITARY)).click();
        $(withText(ISSUE)).click();
        $(withText("#"+ISSUE_NUMBER)).shouldBe(visible);


    }


}
