package Test;

import org.testng.annotations.Test;

public class E2E_Forms_Purchase_Funnel extends BaseTest{

    @Test(dataProvider="PurchaseFunnelsFormForGnowise")
    public void E2E_Purchase_Funnel_IWantToKnowWhatICanAfford(String url, String propertyAddress,String firstname, String lastname, String phoneNumber, String Email, String annualIncome) throws InterruptedException {
        pageFactory.getTestFunnelsPage().GoToUrl(url);
        pageFactory.getTestFunnelsPage().selectIWantToKnowWhatICanAfford("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().enterSubjectPropertyInStepOne(propertyAddress,"oscar-purchase-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().fetchPurchasePrice("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().enterPersonalDetailsInStepThree(firstname,lastname,phoneNumber,Email,"oscar-purchase-form");
        pageFactory.getTestFunnelsPage().enterAnnualIncome(annualIncome,"oscar-purchase-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().fetchDownPayment("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().verifyTheProducts("oscar-purchase-form");
    }


    @Test(dataProvider="PurchaseFunnelsFormForGnowise",dependsOnMethods = "E2E_Purchase_Funnel_IWantToKnowWhatICanAfford")
    public void E2E_Purchase_Funnel_IAmShoppingForANewHome(String url, String propertyAddress,String firstname, String lastname, String phoneNumber, String Email, String annualIncome) throws InterruptedException {
        pageFactory.getTestFunnelsPage().GoToUrl(url);
        pageFactory.getTestFunnelsPage().selectIAmShoppingForANewHome("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().enterSubjectPropertyInStepOne(propertyAddress,"oscar-purchase-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().fetchPurchasePrice("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().enterPersonalDetailsInStepThree(firstname,lastname,phoneNumber,Email,"oscar-purchase-form");
        pageFactory.getTestFunnelsPage().enterAnnualIncome(annualIncome,"oscar-purchase-form");
        pageFactory.getTestFunnelsPage().clickOnContinueButton("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().fetchDownPayment("oscar-purchase-form");
        pageFactory.getTestFunnelsPage().verifyTheProducts("oscar-purchase-form");
    }
}