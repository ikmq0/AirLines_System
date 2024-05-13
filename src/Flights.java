import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Date;

public class Flights extends Main {
    public static ArrayList<Flight>  flightsArrayList = readFile("flights.dat");// This list to store all flights:

    public static void writeInFile(String fileExtension){
        try {
            FileOutputStream location = new FileOutputStream(fileExtension);
            ObjectOutputStream writer = new ObjectOutputStream(location);
            writer.writeObject(flightsArrayList);
            writer.close();
            location.close();
        } catch (IOException ioe) {
            System.out.println("Error saving the file !! ");
        }
    }
    static ArrayList<Flight> list = null;
    public static ArrayList<Flight> readFile(String fileExtension){
        try {
            FileInputStream location = new FileInputStream(fileExtension);
            ObjectInputStream reader = new ObjectInputStream(location);
            list = (ArrayList<Flight>) reader.readObject();
            reader.close();
            return list;
        } catch (IOException ioe) {
            System.out.println("Error reading the file !! ");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found !! ");

        }
        return null;
    }

    public static class Flight extends Flights implements Serializable {
        ArrayList<Seat> seatsArrayList; // This will be an array to store seats for each flight
        private int flightNumber;
        private String departureCity;
        private Date departureDate_Time;
        private Date arrivalDate_Time;
        private String arrivalCity;
        private int gateNumber;

        public Flight(int flightNumber, String departureCity, String arrivalCity, int gateNumber,Date departureDate_Time ,Date arrivalDate_Time) {

            this.flightNumber = flightNumber;
            this.departureCity = departureCity;
            this.arrivalCity = arrivalCity;
            this.gateNumber = gateNumber;
            this.departureDate_Time = departureDate_Time;
            this.arrivalDate_Time = arrivalDate_Time;
            this.seatsArrayList = createSeatsForFlight();
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

        public Date getDepartureDate_Time() {
            return departureDate_Time;
        }

        public Date getArrivalDate_Time() {
            return arrivalDate_Time;
        }

        public void setDepartureDate_Time(Date departureDate_Time) {
            this.departureDate_Time = departureDate_Time;
        }

        public void setArrivalDate_Time(Date arrivalDate_Time) {
            this.arrivalDate_Time = arrivalDate_Time;
        }

        @Override
        public String toString() {
            return "Flight{" +
//                    "seatsArrayList=" + seatsArrayList +
                    ", flightNumber=" + flightNumber +
                    ", departureCity='" + departureCity + '\'' +
                    ", departureDate_Time=" + departureDate_Time +
                    ", arrivalDate_Time=" + arrivalDate_Time +
                    ", arrivalCity='" + arrivalCity + '\'' +
                    ", gateNumber=" + gateNumber +
                    '}';
        }

        public static class Seat implements Serializable{
            private int row;
            private char column;
            private boolean available;

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

            public void setRow(int row) {
                this.row = row;
            }

            public void setColumn(char column) {
                this.column = column;
            }

            public int getRow() {
                return row;
            }

            public char getColumn() {
                return column;
            }

            public boolean isAvailable() {
                return available;
            }

            //------------------------------------------------------------------------------------------------------------------
            // This method will check if the seat available

        }
    }

    public static void createNewFlight(int flightNumber, String departureCity, String arrivalCity, int gateNumber,Date departureDate_Time,Date arrivalDate_Time){
        flightsArrayList.add(new Flight(flightNumber,departureCity,arrivalCity,gateNumber,departureDate_Time,arrivalDate_Time)) ;
    }

    public static ArrayList<Flight> searchForFlightsWArrivalAndDeparture(String departureCity,String arrivalCity) {
        ArrayList<Flight> flights = new ArrayList<>();
        for (Flight flight : flightsArrayList) {
            if (Objects.equals(flight.arrivalCity, arrivalCity) && Objects.equals(flight.departureCity, departureCity)) {
                flights.add(flight);
            }
        }
        return flights;
    }

    public static void printSeatsMap(Flight inputtedFlight) {
        char [] charsList = {'A','B','C','D'};
        System.out.printf("%10s %7s %10s %7s \n",'A','B','C','D');
        for (int i = 1; i<=6;i++) {
            for (char c : charsList) {
                if(Objects.requireNonNull(SearchForSeatByColumn(c, i, inputtedFlight)).isAvailable()) {
                    if (c == 'A' || c=='C'){
                        System.out.printf("%10s%s", c, i );
                    } else {
                        System.out.printf("%7s%s", c, i );
                    }
                } else if(c == 'A' || c=='C') {
                    System.out.printf("%10s%s","N","A");
                } else {
                    System.out.printf("%7s%s", "N","A");
                }
            }
            System.out.println();
            System.out.println();
        }

    }

    public static Flight.Seat SearchForSeatByColumn(char c, int r, Flight inputtedFlight) {
        ArrayList<Flight.Seat> seatsList = inputtedFlight.getSeatsArrayList();
        for (Flight.Seat seat: seatsList) {
            if (seat.column == c && seat.row == r) return seat;
        }
        return null;
    }
    public static Flight searchByFlightNumber(int flightNumber,ArrayList<Flight> flightsList) {
        for (Flight flight: flightsList) {
            if (flight.flightNumber == flightNumber) {
                return flight;
            }
        }
        return null;
    }
    public static void initializeFlights(){
        createNewFlight(1,"DMM","RUH",1,
                new Date(124,6,12,15, 0),
                new Date(124,6,12,17, 0));
        createNewFlight(2,"DMM","JED",2,
                new Date(124,6,16,15, 0),
                new Date(124,6,16,17, 0));
        createNewFlight(3,"DMM","MED",3,
                new Date(124,6,16,15, 0),
                new Date(124,6,16,17, 0));
        createNewFlight(4,"RUH","JED",4,
                new Date(124,6,12,15, 0),
                new Date(124,6,12,17, 0));
        createNewFlight(5,"RUH","DMM",5,
                new Date(124,6, 2,15, 0),
                new Date(124,6,2,17, 0));
        createNewFlight(6,"RUH","MED",6,
                new Date(124,6,1,15, 0),
                new Date(124,6,1,17, 0));
        createNewFlight(7,"JED","MED",7,
                new Date(124,6,10,8, 0),
                new Date(124,6,10,10, 0));
        createNewFlight(8,"JED","DMM",8,
                new Date(124,6,13,7, 0),
                new Date(124,6,13,9, 0));
        createNewFlight(9,"JED","RUH",9,
                new Date(124,6,16,8, 0),
                new Date(124,6,16,10, 0));
        createNewFlight(10,"MED","JED",10,
                new Date(124,6,25,15, 0),
                new Date(124,6,25,17, 0));
        createNewFlight(11,"MED","DMM",11,
                new Date(124,6,4,16, 0),
                new Date(124,6,4,18, 0));
        createNewFlight(12,"MED","RUH",12,
                new Date(124,6,24,12, 0),
                new Date(124,6,24,14, 0));
        createNewFlight(13,"MED","RUH",12,
                new Date(124,6,24,15, 0),
                new Date(124,6,24,17, 0));

    }

    public static void makeSeatUnavailable(char column,int row, int flightNumber){
        for (Flight flight: flightsArrayList) {
            if (flight.flightNumber == flightNumber) {
                for (Flight.Seat seat: flight.seatsArrayList) {
                    if (seat.column == column && seat.row == row) {
                        seat.setAvailable(false);
                    };
                }
            }
        }
    }

}