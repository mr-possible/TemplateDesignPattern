import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CarPage;
import pages.CruisePage;
import pages.FlightPage;
import templates.reservationTemplate;

public class ReservationTest extends BaseTest {


    @Test(dataProvider = "getData")
    public void flightTest(reservationTemplate myTemplate) {
        myTemplate.bookReservation();
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                new FlightPage(driver, "MUMBAI", "RAIPUR", "09/26/2020", "09/30/2020"),
                new CarPage(driver, "MUMBAI", "RAIPUR", "09/26/2020", "09/30/2020"),
                new CruisePage(driver, null, "RAIPUR", "09/26/2020", "09/30/2020")
        };
    }

}
