package tests;

import io.qa_guru.mightyboolik.BaseSteps;
import org.junit.jupiter.api.Test;

public class TestWithAnnotations {
    public BaseSteps steps = new BaseSteps();
    @Test
    public void testIssueSearch(){
        steps.openMainPage();
        steps.searchRepository();
        steps.openRepository();
        steps.openIssuesRepository();
        steps.checkIssueWithNumber();

    }
}
