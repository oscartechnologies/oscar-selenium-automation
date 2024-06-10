package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TestFunnels {

    WebDriver driver;

    public TestFunnels(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void GoToUrl(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(4000);
    }

    public void enterSubjectPropertyInStepOne(String propertyAddress, String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        List<WebElement> subjectPropertyAddress = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[placeholder=\"Location\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : subjectPropertyAddress) {
            // For example, click on each element
            element.sendKeys(propertyAddress);
            ExtentLogger.pass("Enter subject property:- "+propertyAddress);
            Thread.sleep(8000);
        }

        List<WebElement> selectFirstOption = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('ul > li:first-child');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement elements : selectFirstOption) {
            // For example, click on each element
            elements.click();
            Thread.sleep(8000);
        }
    }

    public void enterPropertyValueInStepOne(String propertyValue,String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> enterPropertyValue = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"PropertyValue\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterPropertyValue) {
            // For example, click on each element
            element.sendKeys(propertyValue);
            ExtentLogger.pass("Enter property value:- "+propertyValue);
            Thread.sleep(3000);
        }
    }

    public void enterMortgageValueInStepOne(String mortgageValue,String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> enterMortgageValue = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"mortgageValue\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterMortgageValue) {
            // For example, click on each element
            element.sendKeys(mortgageValue);
            ExtentLogger.pass("Enter mortgage value:- "+mortgageValue);
            Thread.sleep(3000);
        }
    }

    public void clickOnContinueButton(String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> continueButton = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('button[type=\"submit\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : continueButton) {
            // For example, click on each element
            element.click();
            ExtentLogger.pass("Click on continue button");
            Thread.sleep(3000);
        }
    }

    public void enterPersonalDetailsInStepThree(String firstname, String lastname, String phoneNumber, String Email, String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //enter first name
        List<WebElement> enterFirstName = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"firstName\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterFirstName) {
            // For example, click on each element
            element.sendKeys(firstname);
            ExtentLogger.pass("Enter first name:- "+firstname);
            Thread.sleep(3000);
        }

        //enter last name
        List<WebElement> enterLastName = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"lastName\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterLastName) {
            // For example, click on each element
            element.sendKeys(lastname);
            ExtentLogger.pass("Enter last name:- "+lastname);
            Thread.sleep(3000);
        }

        //enter phone number
        List<WebElement> enterPhoneNumber = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"phoneNumber\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterPhoneNumber) {
            // For example, click on each element
            element.sendKeys(phoneNumber);
            ExtentLogger.pass("Enter phone number:- "+phoneNumber);
            Thread.sleep(5000);
        }

        //enter email address
        List<WebElement> enterEmailAddress = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"email\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterEmailAddress) {
            // For example, click on each element
            element.sendKeys(Email);
            ExtentLogger.pass("Enter email address:- "+Email);
            Thread.sleep(3000);
        }
    }

    public void verifyTheProducts(String formSelector) throws InterruptedException {
        Thread.sleep(10000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //enter first name
        List<WebElement> getProduct = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('" + formSelector + "').shadowRoot.querySelectorAll('div[class=\"refinance-products_items_value\"]');");
        // Perform actions on the elements within the shadow DOM
        if (!getProduct.isEmpty()) {
            for (WebElement element : getProduct) {
                String text = element.getText();
                System.out.println(text);
                ExtentLogger.pass("Mortgage option with interest rate is:- " + text);
                Thread.sleep(3000);
            }
        }
        else {
                List<WebElement> getMessage = (List<WebElement>) jsExecutor.executeScript(
                        "return document.querySelector('" + formSelector + "').shadowRoot.querySelectorAll('div[class=\"refinance-cards\"]');");
                for (WebElement messageElement : getMessage) {
                    String message = messageElement.getText();
                    System.out.println(message);
                    ExtentLogger.pass("Message:-" + message);
                    Thread.sleep(3000);
                }
            }
        }

    public void enterPropertyValueInStepOneForGnowise( String formSelector) throws InterruptedException {
        Thread.sleep(5000);
        // Execute JavaScript to find the input element within shadow DOM
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement enterPropertyValue = (WebElement) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelector('input[name=\"PropertyValue\"]');");

        // Check if the element is not null
        if (enterPropertyValue != null) {
            // Retrieve the value attribute of the input element
            String value = enterPropertyValue.getAttribute("value");
            // If you want to print the value to console
            System.out.println("Value Attribute of Property Value from Gnowise:- " + value);
            ExtentLogger.pass("Property Value from Gnowise :- " + value);
        } else {
            ExtentLogger.fail("Element not found"); // Handle case where element is not found
        }
    }

    public void fetchLoanAmount( String formSelector) throws InterruptedException {
        Thread.sleep(5000);
        // Execute JavaScript to find the input element within shadow DOM
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement loanAmount = (WebElement) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelector('input[class=\"input-class\"]');");

        // Check if the element is not null
        if (loanAmount != null) {
            // Retrieve the value attribute of the input element
            String value = loanAmount.getAttribute("value");
            // If you want to print the value to console
            System.out.println("Total loan amount is:- " + value);
            ExtentLogger.pass("Total loan amount is :- " + value);
        } else {
            ExtentLogger.fail("Element not found"); // Handle case where element is not found
        }
    }

    public void enterMonthlyExpenses(String monthlyExpenses, String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> enterMonthlyExpenses = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"totalMonthlyExpenses\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterMonthlyExpenses) {
            // For example, click on each element
            element.sendKeys(monthlyExpenses);
            ExtentLogger.pass("Enter monthly expenses:- "+monthlyExpenses);
            Thread.sleep(3000);
        }
    }

    public void enterAnnualIncome(String annualIncome, String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> enterMonthlyExpenses = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"annualIncome\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterMonthlyExpenses) {
            // For example, click on each element
            element.sendKeys(annualIncome);
            ExtentLogger.pass("Enter mortgage value:- "+annualIncome);
            Thread.sleep(3000);
        }
    }

    public void selectIWantToKnowWhatICanAfford(String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> firstPurchaseOption = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('div[class=\"btn-container cont-1\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : firstPurchaseOption) {
            // For example, click on each element
            element.click();
            ExtentLogger.pass("Click On : I Want To Know What I Can Afford");
            Thread.sleep(3000);
        }
    }

    public void selectIAmShoppingForANewHome(String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> firstPurchaseOption = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('div[class=\"btn-container cont-2\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : firstPurchaseOption) {
            // For example, click on each element
            element.click();
            ExtentLogger.pass("Click On : I have found my new home");
            Thread.sleep(3000);
        }
    }

    public void selectMyOfferHaveBeenAccepted(String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> firstPurchaseOption = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('div[class=\"btn-container cont-4\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : firstPurchaseOption) {
            // For example, click on each element
            element.click();
            ExtentLogger.pass("Click On : My offer have been accepted");
            Thread.sleep(3000);
        }
    }

    public void selectIHaveFoundMyNewHome(String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> firstPurchaseOption = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('div[class=\"btn-container cont-3\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : firstPurchaseOption) {
            // For example, click on each element
            element.click();
            ExtentLogger.pass("Click On : I am shopping for a new home");
            Thread.sleep(3000);
        }
    }

    public void fetchPurchasePrice(String formSelector) throws InterruptedException {
        Thread.sleep(5000);
        // Execute JavaScript to find the input element within shadow DOM
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement purchasePrice = (WebElement) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelector('input[name=\"purchasePrice\"]');");

        // Check if the element is not null
        if (purchasePrice != null) {
            // Retrieve the value attribute of the input element
            String value = purchasePrice.getAttribute("value");
            // If you want to print the value to console
            ExtentLogger.pass("Total purchase price is :- " + value);
        } else {
            ExtentLogger.fail("Element not found"); // Handle case where element is not found
        }
    }

    public void fetchDownPayment(String formSelector) throws InterruptedException {
        Thread.sleep(5000);
        // Execute JavaScript to find the input element within shadow DOM
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> downPayment = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('div[class=\"content-title-class big-screen-class\"]');");
        // Check if the element is not null
        for(WebElement element : downPayment) {
            // Retrieve the value attribute of the input element
            String value = element.getText();
            // If you want to print the value to console
            ExtentLogger.pass(value);
        }
    }

    public void fetchEstimatedPurchasePrice(String formSelector) throws InterruptedException {
        Thread.sleep(5000);
        // Execute JavaScript to find the input element within shadow DOM
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement purchasePrice = (WebElement) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelector('input[name=\"annualIncome\"]');");

        // Check if the element is not null
        if (purchasePrice != null) {
            // Retrieve the value attribute of the input element
            String value = purchasePrice.getAttribute("value");
            // If you want to print the value to console
            ExtentLogger.pass("Total purchase price is :- " + value);
        } else {
            ExtentLogger.fail("Element not found"); // Handle case where element is not found
        }
    }

    public void enterClosingDate(String formSelector) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<WebElement> enterClosingDate = (List<WebElement>) jsExecutor.executeScript(
                "return document.querySelector('"+formSelector+"').shadowRoot.querySelectorAll('input[name=\"PropertyValue\"]');");
        // Perform actions on the elements within the shadow DOM
        for (WebElement element : enterClosingDate) {
            // For example, click on each element
            element.click();
            element.sendKeys("05062025");
            Thread.sleep(3000);
            ExtentLogger.pass("Enter property value:- "+"05/06/2025");
            Thread.sleep(3000);
        }
    }
}