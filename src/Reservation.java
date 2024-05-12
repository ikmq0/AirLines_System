import java.util.ArrayList;

public class Reservation extends Main {
    static ArrayList<Reservation> reservationArrayList= new ArrayList<>();
    private ArrayList<Ticket> ticketsList;
    private long reservationNumber;

    public Reservation( ArrayList<Ticket> ticketsList, long reservationNumber) {
        this.ticketsList = ticketsList;
        this.reservationNumber = reservationNumber;
    }


}