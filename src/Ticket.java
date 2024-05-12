public class Ticket {
    private String passengerFirstName;
    private String passengerLastName;
    private String passportNumber;
    private Flights.Flight flight;
    private Flights.Flight.Seat seat;

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Flights.Flight getFlight() {
        return flight;
    }

    public void setFlight(Flights.Flight flight) {
        this.flight = flight;
    }

    public Flights.Flight.Seat getSeat() {
        return seat;
    }

    public void setSeat(Flights.Flight.Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "passengerFirstName='" + passengerFirstName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", flight=" + flight +
                ", seat=" + seat +
                '}';
    }
}
