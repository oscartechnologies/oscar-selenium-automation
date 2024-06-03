package Test;

import org.testng.annotations.Test;

public class E2E_Forms_Refinance_Funnel extends BaseTest {

    @Test(dataProvider="RefinanceFunnelsFormForGnowise")
    public void E2E_Refinance_Funnel(String url, String propertyAddress,String mortgageValue,String monthlyExpenses, String firstname, String lastname, String phoneNumber, String Email, String annualIncome) throws InterruptedException {
        pageFactory.getTestFunnelsPage().GoToUrl(url);
        pageFactory.getTestFunnelsPage().enterSubjectPropertyInStepOne(propertyAddress,"oscar-refinance-form");
        pageFactory.getTestFunnelsPage().enterPropertyValueInStepOneForGnowise("oscar-refinance-form");
        pageFactory.getTestFunnelsPage().enterMortgageValueInStepOne(mortgageValue,"oscar-refinance-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-refinance-form");
        pageFactory.getTestFunnelsPage().fetchLoanAmount("oscar-refinance-form");
        pageFactory.getTestFunnelsPage().enterMonthlyExpenses(monthlyExpenses,"oscar-refinance-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-refinance-form");
        pageFactory.getTestFunnelsPage().enterPersonalDetailsInStepThree(firstname,lastname,phoneNumber,Email,"oscar-refinance-form");
        pageFactory.getTestFunnelsPage().enterAnnualIncome(annualIncome,"oscar-refinance-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-refinance-form");
        pageFactory.getTestFunnelsPage().verifyTheProducts("oscar-refinance-form");
    }
}