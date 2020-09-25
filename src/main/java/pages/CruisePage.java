package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import templates.reservationTemplate;

/**
 * Created By: Sambhav
 * Created On: 25-09-2020 || 10:10 PM
 * Project Name: TemplateDesignPattern
 **/

public class CruisePage extends reservationTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;

    @FindBy(id = "tab-cruise-tab-hp")
    private WebElement btn_CruiseOptionSelect;

    @FindBy(id = "cruise-destination-hp-cruise")
    private WebElement dd_CruiseDest;

    @FindBy(id = "cruise-start-date-hp-cruise")
    private WebElement txt_DepartureDate;

    @FindBy(id = "cruise-end-date-hp-cruise")
    private WebElement txt_ReturnDate;

    @FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[8]/label/button")
    private WebElement btn_Search;

    public CruisePage(WebDriver driver, String origin, String destination, String departureDate, String returnDate) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void landOnMainPage() {
        driver.get("https://www.orbitz.com/");
    }

    @Override
    public void chooseTypeOfTravel() {
        this.btn_CruiseOptionSelect.click();
    }

    @Override
    public void selectSourceOfTravel() {
    }

    @Override
    public void selectDestinationOfTravel() {
        Select s = new Select(this.dd_CruiseDest);
        s.selectByVisibleText(destination);
    }

    @Override
    public void departureDate() {
        this.txt_DepartureDate.sendKeys(departureDate + Keys.ENTER);
    }

    @Override
    public void returnDate() {
        this.txt_ReturnDate.sendKeys(returnDate + Keys.ENTER);
    }

    @Override
    public void search() {
        this.btn_Search.click();
    }

}
