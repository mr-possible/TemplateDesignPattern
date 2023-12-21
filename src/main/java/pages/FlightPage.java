package pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import templates.reservationTemplate;

import java.util.concurrent.TimeUnit;


public class FlightPage extends reservationTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement btn_FlightOptionSelect;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement txt_FlightSource;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement txt_FlightDestination;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement txt_DepartureDate;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement txt_ArrivalDate;

    @FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[8]/label/button")
    private WebElement btn_Search;

    public FlightPage(WebDriver driver, String origin, String destination, String departureDate, String returnDate) {
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
        this.btn_FlightOptionSelect.click();
    }

    @Override
    public void selectSourceOfTravel() {
        this.txt_FlightSource.click();
        this.txt_FlightSource.sendKeys(this.origin);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@id='autocomplete-dropdown-flight-origin-hp-flight']/div/li[1]")).click();
    }

    @Override
    public void selectDestinationOfTravel() {
        this.txt_FlightDestination.click();
        this.txt_FlightDestination.sendKeys(this.destination);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@id='autocomplete-dropdown-flight-destination-hp-flight']/div/li[1]")).click();
    }

    @Override
    public void departureDate() {
        this.txt_DepartureDate.sendKeys(departureDate + Keys.ENTER);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Override
    public void returnDate() {
        this.txt_ArrivalDate.sendKeys(returnDate + Keys.ENTER);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Override
    public void search() {
        this.btn_Search.click();
    }

}
