public class Ticket {
    private Passenger passenger;
    private Flights.Flight flight;
    private Flights.Flight.Seat seat;

    public Passenger getPassenger() {
        return passenger;
    }

    public Flights.Flight getFlight() {
        return flight;
    }

    public Flights.Flight.Seat getSeat() {
        return seat;
    }

    public int getSeatRow() {
        return seat.row;
    }

    public char getSeatColumn() {
        return seat.column;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFlight(Flights.Flight flight) {
        this.flight = flight;
    }

    public void setSeat(Flights.Flight.Seat seat) {
        this.seat = seat;
    }

    public void setSeatRow(int seatRow) {
        this.seat.row = seatRow;
    }

    public void setSeatColumn(char seatColumn) {
        this.seat.column = seatColumn;
    }
    // khaled please check here and tell me if the seat number and row can be accessed from the seat class in flight class
    public String toString(){
        return "Ticket to flight "+ flight.getFlightNumber() +
                "Passenger name is: " + passenger.getName() +
                "with Passport number: " + passenger.getPassportNumber() +
                "Seat row: " + seat.row + "Seat col: " + seat.column;
    }
}
