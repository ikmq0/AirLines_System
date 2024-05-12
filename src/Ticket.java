public class Ticket {
    private String passengerFirstName;
    private String passengerLastName;
    private int passengerAge;
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

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public void setSeat(Flights.Flight.Seat seat) {
        this.seat = seat;
    }


    public Ticket(String passengerFirstName, String passengerLastName, int passengerAge, String passportNumber, Flights.Flight flight, Flights.Flight.Seat seat) {
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.passengerAge = passengerAge;
        this.passportNumber = passportNumber;
        this.flight = flight;
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
