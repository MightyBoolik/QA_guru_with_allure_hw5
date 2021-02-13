package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class IssueTestSteps {
    public static final String ISSUE = "Issue";
    public static final String REPOSITARY = "MightyBoolik/QA_guru_with_allure_hw5";
    public static final int ISSUE_NUMBER = 1;
    public static final String BASE_URL = "https://github.com/";


    @Test
    @Link(name = "base url", value = BASE_URL)
    @Owner("MightyBoolik")
    @Tags ({@Tag("web"),@Tag("critical")})
    @Feature("Issues")
    @Story("Поиск issue в репозитории")
    @DisplayName("Поиск issue по номеру внутри репозитория")
    public void testGithubIssue(){
        parameter("Repository",REPOSITARY);
        parameter("Issue number",ISSUE_NUMBER);

        step("Открываем главную страницу",() ->{
            open(BASE_URL);
        });
        step("Поиск репозитория" + REPOSITARY, () ->{
            $(byName("q")).val(REPOSITARY).pressEnter();
        });
        step("Переход в репозиторий" + REPOSITARY,() ->{
            $(By.linkText(REPOSITARY)).click();
        });
        step("Переход в раздел" +ISSUE,() ->{
            $(withText(ISSUE)).click();
        });
        step("Проверка наличия"+ ISSUE +"с номером"+ ISSUE_NUMBER);
        $(withText("#"+ISSUE_NUMBER)).shouldBe(visible);


    }
}
