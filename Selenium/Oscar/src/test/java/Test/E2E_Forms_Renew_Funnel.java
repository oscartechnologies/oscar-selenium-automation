package Test;

import org.testng.annotations.Test;

public class E2E_Forms_Renew_Funnel extends BaseTest {

    @Test(dataProvider="RenewFunnelsFormForGnowise")
    public void E2E_Renew_Funnel(String url, String propertyAddress,String mortgageValue,String monthlyExpenses, String firstname, String lastname, String phoneNumber, String Email, String annualIncome) throws InterruptedException {
        pageFactory.getTestFunnelsPage().GoToUrl(url);
        pageFactory.getTestFunnelsPage().enterSubjectPropertyInStepOne(propertyAddress,"oscar-renewal-form");
        pageFactory.getTestFunnelsPage().enterPropertyValueInStepOneForGnowise("oscar-renewal-form");
        pageFactory.getTestFunnelsPage().enterMortgageValueInStepOne(mortgageValue,"oscar-renewal-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-renewal-form");
        pageFactory.getTestFunnelsPage().enterMonthlyExpenses(monthlyExpenses,"oscar-renewal-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-renewal-form");
        pageFactory.getTestFunnelsPage().enterPersonalDetailsInStepThree(firstname,lastname,phoneNumber,Email,"oscar-renewal-form");
        pageFactory.getTestFunnelsPage().enterAnnualIncome(annualIncome,"oscar-renewal-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-renewal-form");
        pageFactory.getTestFunnelsPage().verifyTheProducts("oscar-renewal-form");
    }
}