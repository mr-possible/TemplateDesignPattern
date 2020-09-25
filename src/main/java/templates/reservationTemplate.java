package templates;

/**
 * Created By: Sambhav
 * Created On: 25-09-2020 || 09:56 PM
 * Project Name: TemplateDesignPattern
 **/


public abstract class reservationTemplate {

    public abstract void landOnMainPage();

    public abstract void chooseTypeOfTravel();

    public abstract void selectSourceOfTravel();

    public abstract void selectDestinationOfTravel();

    public abstract void departureDate();

    public abstract void returnDate();

    public abstract void search();

    public void bookReservation() {
        landOnMainPage();
        chooseTypeOfTravel();
        selectSourceOfTravel();
        selectDestinationOfTravel();
        departureDate();
        returnDate();
        search();
    }

}
