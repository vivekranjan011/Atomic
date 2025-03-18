package builder;

public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additionalneeds;
    private BookingDates bookingdates;

    public Booking(BookingBuilder bookingBuilder) {
        this.firstname = bookingBuilder.firstname;
        this.lastname = bookingBuilder.lastname;
        this.totalprice = bookingBuilder.totalprice;
        this.depositpaid = bookingBuilder.depositpaid;
        this.additionalneeds = bookingBuilder.additionalneeds;
        this.bookingdates = bookingBuilder.bookingdates;
    }

    public static class BookingDates{
        private String checkin;
        private String checkout;

        public BookingDates(BookingDatesBuilder bookingDatesBuilder) {
            this.checkin = bookingDatesBuilder.checkin;
            this.checkout = bookingDatesBuilder.checkout;
        }

        public static  class BookingDatesBuilder{
            private String checkin;
            private String checkout;

            public BookingDatesBuilder setCheckin(String checkin) {
                this.checkin = checkin;
                return this;
            }

            public BookingDatesBuilder setCheckout(String checkout) {
                this.checkout = checkout;
                return this;
            }

            public BookingDates build(){
                return new BookingDates(this);
            }
        }
    }

    public static class BookingBuilder{
        private String firstname;
        private String lastname;
        private int totalprice;
        private boolean depositpaid;
        private String additionalneeds;
        private BookingDates bookingdates;

        public BookingBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public BookingBuilder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public BookingBuilder setTotalprice(int totalprice) {
            this.totalprice = totalprice;
            return this;
        }

        public BookingBuilder setDepositpaid(boolean depositpaid) {
            this.depositpaid = depositpaid;
            return this;
        }

        public BookingBuilder setAdditionalneeds(String additionalneeds) {
            this.additionalneeds = additionalneeds;
            return this;
        }

        public BookingBuilder setBookingDates(BookingDates bookingdates) {
            this.bookingdates = bookingdates;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
