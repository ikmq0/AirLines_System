public class Flights {
    // Here is flights functions & seats
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private int gateNumber;
    private String[][] seatMap;
    private int row;
    private int column;

    //------------------------------------------------------------------------------------------------------------------
    // I changed r to row and c to column to make it easier to work with
    public Flight(String flightNumber, String departureCity, String arrivalCity, int gateNumber, int row, int column) {

        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.gateNumber = gateNumber;
        this.seatMap = new String[row][column];
        this.row = row;
        this.column = column;
    }

    //------------------------------------------------------------------------------------------------------------------
    public String getFlightNumber() {
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
    public String[][] getSeatMap() {
        return seatMap;
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
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    //----------------------------------------------------------------------------------------------------------------
    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    //------------------------------------------------------------------------------------------------------------------
    // This method will add the booked seat to the seatMap
    public boolean bookSeat(int row, char column, String passengerID) {

        // Just to match the output row
        int adjustedRow = row - 1;

        // Convert char to integer to work with it
        int columnIdx = column - 'A';

        if (isSeatAvailable(adjustedRow, column)) {
            getSeatMap()[adjustedRow][columnIdx] = passengerID;
            return true;
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------------
    // This method will check if the seat available
    public boolean isSeatAvailable(int row, char column) {

        // We changed char to int so we can use it in the index
        int columnIndex = column - 'A';

        return row >= 0 && row < getSeatMap().length
                && columnIndex >= 0 && columnIndex < getSeatMap()[row].length
                && getSeatMap()[row][columnIndex] == null;
    }

    //------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Flight{" + "flightNumber=" + flightNumber + ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity + ", gateNumber=" + gateNumber + ", row=" + row + ", column=" + column + '}';
    }

}