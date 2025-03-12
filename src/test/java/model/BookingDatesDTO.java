package model;

public class BookingDatesDTO {
    private String checkin;
    private String checkout;

    public BookingDatesDTO(String checkin, String checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }


    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckin() {
        return checkin;
    }


    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckout() {
        return checkout;
    }

    
    @Override
    public String toString() {
        return "BookingDates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
