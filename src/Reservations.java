import java.util.ArrayList;
import java.util.Random;

public class Reservations extends Main {
    public static ArrayList<Reservation> reservationArrayList = new ArrayList<>();
    static Random random = new Random();

    public static class Reservation extends Reservations {
        ArrayList<Ticket> ticketsList;
        private long reservationNumber;

        public Reservation(ArrayList<Ticket> ticketsList, long reservationNumber) {
            this.ticketsList = ticketsList;
            this.reservationNumber = reservationNumber;
        }

        public Reservation() {
        }
        public ArrayList<Ticket> getTicketsList() {
            return ticketsList;
        }

        public long getReservationNumber() {
            return reservationNumber;
        }

        @Override
        public String toString() {
            return "Reservation{" +
                    "ticketsList=" + ticketsList +
                    ", reservationNumber=" + reservationNumber +
                    '}';
        }
    }


    public static Reservation createNewReservation(){
        long generatedNumber =random.nextLong(1000,9999);
        while(SearchForReservation(generatedNumber) != null) {
            generatedNumber =random.nextLong(1000,9999);
        }

        return new Reservation(new ArrayList<>(),generatedNumber);

    }

    public static Reservation SearchForReservation(long number) {
        for(Reservation r : Reservations.reservationArrayList) {
            if (r.getReservationNumber() == number) return r;
        }
        return null;
    }


}