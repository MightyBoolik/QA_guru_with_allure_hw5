package io.qa_guru.mightyboolik;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    private static final int ISSUE_NUMBER = 1;
    private static final String ISSUE = "Issue";
    private static final String REPOSITARY = "MightyBoolik/QA_guru_with_allure_hw5";
    private static final String BASE_URL = "https://github.com/";

    @Step("Открытие адреса главной страницы")
    public void openMainPage(){
        open(BASE_URL);
    }
    @Step("Поиск репозитория{repository}")
    public void searchRepository(){
        $(byName("q")).val(REPOSITARY).pressEnter();
    }
    @Step("Переход в репозиторий{repository}")
    public void openRepository(){
        $(By.linkText(REPOSITARY)).click();
    }
    @Step("Переход в раздел Issues")
    public void openIssuesRepository(){
        $(withText(ISSUE)).click();
    }
    @Step("Проверка наличия Issues с {number}")
    public void checkIssueWithNumber(){
        $(withText("#"+ISSUE_NUMBER)).shouldBe(visible);
    }
}
