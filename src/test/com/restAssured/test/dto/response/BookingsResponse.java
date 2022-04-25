package restAssured.test.dto.response;

import restAssured.test.dto.BookingDTO;

import java.io.Serializable;

public class BookingsResponse implements Serializable  {

    Integer bookingid;
    BookingDTO booking;


    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBooking(BookingDTO booking) {
        this.booking = booking;
    }
}
