package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.BasePage;
import selenium.pages.BookingPageDOM;


public class BookingTest extends TestBase {
    BookingPageDOM bookingPage;
    Logger logger= LogManager.getLogger(LoginPageTest.class);

    @Test public void testBookingSearch() {
        // Open the site
        BasePage.openSite("https://www.msccrociere.it");

        out.println("Starting booking test...");

        out.println("Paso 1 completado");
        bookingPage.testFYI();

        out.println("Paso 2 completado");
        bookingPage.selectCruiseCard();

        out.println("Paso 3 completado");
        bookingPage.selectOffer();

        out.println("Paso 4 completado");
        bookingPage.selectCabin();

        out.println("Paso 5 completado");
        bookingPage.selectExperience();

        out.println("Paso 6 completado");
        bookingPage.selectCabinPosition();

        out.println("Paso 7 completado");
        bookingPage.selectCabinNumber();

        out.println("Paso 8 completado");
        bookingPage.passengerRegister();

        out.println("Paso 9 completado");
        bookingPage.selectSpecialOffers();

        out.println("Paso 10 completado");
        bookingPage.proceedToCheckout();

        // Validation
        Assert.assertTrue(driver.getTitle().contains("Results"), "Search was not successful.");

}
