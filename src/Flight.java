import java.io.Serializable;
import java.util.ArrayList;

public class Flight extends Main implements Serializable {
    public static ArrayList<Flight> flightsArrayList = new ArrayList<>(); // This list to store all flights:
    private static ArrayList<Seat> seatsArrayList; // This will be an array to store seats for each flight
    // Here is flights functions & seats
    private static int flightNumber;
    private static String departureCity;
    private static String arrivalCity;
    private static int gateNumber;



    public Flight(int flightNumber, String departureCity, String arrivalCity, int gateNumber) {

        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.gateNumber = gateNumber;
        this.seatsArrayList = createSeatsForFlight();
    }

    public static void createNewFlight(int flightNumber, String departureCity, String arrivalCity, int gateNumber){
        flightsArrayList.add(new Flight(flightNumber,departureCity,arrivalCity,gateNumber)) ;
    }

    public ArrayList<Seat> createSeatsForFlight(){
        ArrayList<Seat> seats = new ArrayList<>();
        for(int i =1; i <=4; i++){
            for (int j = 1; j<= 6; j++) {
                seats.add(new Seat(i,j));
            }
        }
        return seats;
    }

    //------------------------------------------------------------------------------------------------------------------
    public int getFlightNumber() {
        return flightNumber;
    }

    //------------------------------------------------------------------------------------------------------------------
    public String getDepartureCity() {
        return departureCity;
    }

    //------------------------------------------------------------------------------------------------------------------
    public String getArrivalCity() {
        return arrivalCity;
    }

    //------------------------------------------------------------------------------------------------------------------
    public int getGateNumber() {
        return gateNumber;
    }

    //------------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------------
    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    //------------------------------------------------------------------------------------------------------------------
    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    //------------------------------------------------------------------------------------------------------------------
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    //----------------------------------------------------------------------------------------------------------------
    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    //------------------------------------------------------------------------------------------------------------------
    // This method will add the booked seat to the seatMap

    @Override
    public String toString() {
        return "Flight{" + "flightNumber=" + flightNumber + ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity + ", gateNumber=" + gateNumber + ", SeatsList" + seatsArrayList +'}';
    }

    public static class Seat{
        public int row;
        public int column;
        public boolean available;

        public Seat(int row, int column) {
            this.row = row;
            this.column = column;
            this.available = true;
        }

        @Override
        public String toString() {
            return "Seat{" +row + column+
                    ", available=" + available +
                    '}';
        }

        //------------------------------------------------------------------------------------------------------------------
        // This method will check if the seat available

    }

    public static void main(String[] args) {
        createNewFlight(1,"DMM","JED",1);
        System.out.println(flightsArrayList);
    }

}