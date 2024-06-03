package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private TestFunnels testFunnels;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }


    public TestFunnels getTestFunnelsPage() {
        if (testFunnels == null) {
            testFunnels = new TestFunnels(driver);
        }
        return testFunnels;
    }
}