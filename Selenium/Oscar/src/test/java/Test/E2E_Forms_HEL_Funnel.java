package Test;

import org.testng.annotations.Test;

public class E2E_Forms_HEL_Funnel extends BaseTest{

    @Test(dataProvider="HElFunnelsForm")
    public void E2E_HEL_Funnel(String url, String propertyAddress, String propertyValue,String mortgageValue, String firstname, String lastname, String phoneNumber, String Email) throws InterruptedException {
        pageFactory.getTestFunnelsPage().GoToUrl(url);
        pageFactory.getTestFunnelsPage().enterSubjectPropertyInStepOne(propertyAddress, "oscar-hel-form");
        pageFactory.getTestFunnelsPage().enterPropertyValueInStepOne(propertyValue,"oscar-hel-form");
        pageFactory.getTestFunnelsPage().enterMortgageValueInStepOne(mortgageValue,"oscar-hel-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-hel-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-hel-form");
        pageFactory.getTestFunnelsPage().enterPersonalDetailsInStepThree(firstname,lastname,phoneNumber,Email,"oscar-hel-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-hel-form");
        pageFactory.getTestFunnelsPage().verifyTheProducts("oscar-hel-form");
    }

    @Test(dataProvider="HElFunnelsFormForGnowise", dependsOnMethods = "E2E_HEL_Funnel" )
    public void E2E_HEL_Funnels_Gnowise(String url, String propertyAddress,String mortgageValue, String firstname, String lastname, String phoneNumber, String Email) throws InterruptedException {
        pageFactory.getTestFunnelsPage().GoToUrl(url);
        pageFactory.getTestFunnelsPage().enterSubjectPropertyInStepOne(propertyAddress,"oscar-hel-form");
        pageFactory.getTestFunnelsPage().enterPropertyValueInStepOneForGnowise("oscar-hel-form");
        pageFactory.getTestFunnelsPage().enterMortgageValueInStepOne(mortgageValue,"oscar-hel-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-hel-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-hel-form");
        pageFactory.getTestFunnelsPage().enterPersonalDetailsInStepThree(firstname,lastname,phoneNumber,Email,"oscar-hel-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-hel-form");
        pageFactory.getTestFunnelsPage().verifyTheProducts("oscar-hel-form");
    }
}