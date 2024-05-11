import java.sql.SQLOutput;
import java.util.ArrayList;

public class Flights extends Main {
    public static ArrayList<Flight> flightsArrayList = new ArrayList<>(); // This list to store all flights:

    public static class Flight extends Flights {
        private static ArrayList<Seat> seatsArrayList; // This will be an array to store seats for each flight
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

        public static ArrayList<Seat> createSeatsForFlight(){
            ArrayList<Seat> seats = new ArrayList<>();
            char [] charactersList = {'A','B','C','D'};
            for(int i =0; i <= 3 ; i++){
                for (int j = 1; j<= 6; j++) {
                    seats.add(new Seat(charactersList[i],j));
                }
            }
            return seats;
        }

        //------------------------------------------------------------------------------------------------------------------
        public int getFlightNumber() {
            return this.flightNumber;
        }

        //------------------------------------------------------------------------------------------------------------------
        public String getDepartureCity() {
            return this.departureCity;
        }

        //------------------------------------------------------------------------------------------------------------------
        public String getArrivalCity() {
            return this.arrivalCity;
        }

        //------------------------------------------------------------------------------------------------------------------
        public int getGateNumber() {
            return this.gateNumber;
        }

        //------------------------------------------------------------------------------------------------------------------


        public ArrayList<Seat> getSeatsArrayList() {
            return this.seatsArrayList;
        }

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
            public char column;
            public boolean available;

            public Seat(char column, int row) {
                this.column = column;
                this.row = row;
                this.available = true;
            }

            @Override
            public String toString() {
                return "Seat{" + column + row+
                        ", available=" + available +
                        '}';
            }

            public void setAvailable(boolean available) {
                this.available = available;
            }

            //------------------------------------------------------------------------------------------------------------------
            // This method will check if the seat available

        }
    }

    public static void printSeatsMap(Flight inputtedFlight) {
        char [] charsList = {'A','B','C','D'};
        System.out.printf("%10s %10s %10s %10s \n",'A','B','C','D');
        for (int i = 1; i<=6;i++) {
            for (char c : charsList) {
                if(isAvailable(c,i,inputtedFlight)) {
                    System.out.printf("%10s%s", c, i );
                } else {
                    System.out.printf("%10s","NA");
                }
            }
            System.out.println();
            System.out.println();
        }

    }

    public static boolean isAvailable(char c,int r,Flight inputtedFlight) {
        ArrayList<Flight.Seat> seatsList = inputtedFlight.getSeatsArrayList();
        for (Flight.Seat seat: seatsList) {
            if (seat.column == c && seat.row == r && seat.available) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Flight.createNewFlight(1,"DMM","JED",1);
        Flight.createNewFlight(1,"JED","MED",1);
        Flight.createNewFlight(1,"RUH","JED",1);
        flightsArrayList.getFirst().getSeatsArrayList().getFirst().setAvailable(false);
        System.out.println(flightsArrayList);
        printSeatsMap(flightsArrayList.getFirst());

    }





}